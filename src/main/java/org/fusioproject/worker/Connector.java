package org.fusioproject.worker;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.fusioproject.worker.connector.Connection;
import org.fusioproject.worker.connector.Connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connector {
    private final Connections connections;
    private final HashMap<String, Object> instances;

    public Connector(Connections connections) {
        this.connections = connections;
        this.instances = new HashMap<>();
    }

    public Object getConnection(String name) {
        if (this.instances.containsKey(name)) {
            return this.instances.get(name);
        }

        if (!this.connections.containsKey(name)) {
            throw new RuntimeException("Provided connection is not configured");
        }

        Connection connection = this.connections.get(name);

        if (connection.getType().equals("Fusio.Adapter.Sql.Connection.Sql")) {
            java.sql.Connection con;
            if (connection.getConfig().get("type").equals("pdo_mysql")) {
                con = this.newSqlConnection("mysql://" + connection.getConfig().get("host") + ":3306/" + connection.getConfig().get("database") + "?user=" + connection.getConfig().get("username") + "&password=" + connection.getConfig().get("password"));
            } else if (connection.getConfig().get("type").equals("pdo_pgsql")) {
                con = this.newSqlConnection("postgresql://" + connection.getConfig().get("host") + ":5432/" + connection.getConfig().get("database") + "?user=" + connection.getConfig().get("username") + "&password=" + connection.getConfig().get("password"));
            } else {
                throw new RuntimeException("SQL type is not supported");
            }

            this.instances.put(name, con);

            return con;
        } else if (connection.getType().equals("Fusio.Adapter.Sql.Connection.SqlAdvanced")) {
            java.sql.Connection con = this.newSqlConnection(connection.getConfig().get("url"));

            this.instances.put(name, con);

            return con;
        } else if (connection.getType().equals("Fusio.Adapter.Http.Connection.Http")) {
            HttpClientBuilder builder = HttpClientBuilder.create();
            HttpClient client = builder.build();

            // @TODO configure a base url so that the action can only make requests against this base url
            //connection.getConfig().get("url");

            // @TODO configure proxy for http client
            //connection.getConfig().get("username");
            //connection.getConfig().get("password");
            //connection.getConfig().get("proxy");

            this.instances.put(name, client);

            return client;
        } else if (connection.getType().equals("Fusio.Adapter.Mongodb.Connection.MongoDB")) {
            MongoClient client = MongoClients.create(connection.getConfig().get("url"));
            MongoDatabase database = client.getDatabase(connection.getConfig().get("database"));

            this.instances.put(name, database);

            return database;
        } else if (connection.getType().equals("Fusio.Adapter.Elasticsearch.Connection.Elasticsearch")) {
            RestHighLevelClient client = this.newElasticsearchClient(connection.getConfig().get("host"));

            this.instances.put(name, client);

            return client;
        } else {
            throw new RuntimeException("Provided a not supported connection type");
        }
    }

    private java.sql.Connection newSqlConnection(String url) {
        try {
            return DriverManager.getConnection("jdbc:" + url);
        } catch (SQLException e) {
            throw new RuntimeException("Could not obtain connection", e);
        }
    }

    private RestHighLevelClient newElasticsearchClient(String host) {
        String[] hosts = host.split(",");
        List<HttpHost> list = new ArrayList<>();
        for (String raw : hosts) {
            String[] parts = raw.split(":", 2);
            if (parts.length == 1) {
                list.add(new HttpHost(parts[0]));
            } else if (parts.length == 2) {
                list.add(new HttpHost(parts[0], Integer.parseInt(parts[1])));
            }
        }

        if (list.size() == 0) {
            throw new RuntimeException("Provided host list is empty");
        }

        return new RestHighLevelClient(RestClient.builder(list.toArray(new HttpHost[0])));
    }
}
