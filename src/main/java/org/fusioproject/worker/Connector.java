package org.fusioproject.worker;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.fusioproject.worker.generated.ExecuteConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Connector {
    private final Map<String, ExecuteConnection> connections;
    private final HashMap<String, Object> instances;
    private final ObjectMapper objectMapper;

    public Connector(Map<String, ExecuteConnection> connections) {
        this.connections = connections;
        this.instances = new HashMap<>();
        this.objectMapper = new ObjectMapper();
    }

    public Object getConnection(String name) throws IOException {
        if (this.instances.containsKey(name)) {
            return this.instances.get(name);
        }

        if (!this.connections.containsKey(name)) {
            throw new RuntimeException("Provided connection is not configured");
        }

        ExecuteConnection connection = this.connections.get(name);
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<>() {};
        HashMap<String, String> config = this.objectMapper.readValue(Base64.getDecoder().decode(connection.getConfig()), typeRef);

        if (connection.getType().equals("Fusio.Adapter.Sql.Connection.Sql")) {
            java.sql.Connection con;
            if (config.get("type").equals("pdo_mysql")) {
                con = this.newSqlConnection("mysql://" + config.get("host") + ":3306/" + config.get("database") + "?user=" + config.get("username") + "&password=" + config.get("password"));
            } else if (config.get("type").equals("pdo_pgsql")) {
                con = this.newSqlConnection("postgresql://" + config.get("host") + ":5432/" + config.get("database") + "?user=" + config.get("username") + "&password=" + config.get("password"));
            } else {
                throw new RuntimeException("SQL type is not supported");
            }

            this.instances.put(name, con);

            return con;
        } else if (connection.getType().equals("Fusio.Adapter.Sql.Connection.SqlAdvanced")) {
            java.sql.Connection con = this.newSqlConnection(config.get("url"));

            this.instances.put(name, con);

            return con;
        } else if (connection.getType().equals("Fusio.Adapter.Http.Connection.Http")) {
            HttpClientBuilder builder = HttpClientBuilder.create();
            HttpClient client = builder.build();

            // @TODO configure a base url so that the action can only make requests against this base url
            //config.get("url");

            // @TODO configure proxy for http client
            //config.get("username");
            //config.get("password");
            //config.get("proxy");

            this.instances.put(name, client);

            return client;
        } else if (connection.getType().equals("Fusio.Adapter.Mongodb.Connection.MongoDB")) {
            MongoClient client = MongoClients.create(config.get("url"));
            MongoDatabase database = client.getDatabase(config.get("database"));

            this.instances.put(name, database);

            return database;
        } else if (connection.getType().equals("Fusio.Adapter.Elasticsearch.Connection.Elasticsearch")) {
            ElasticsearchClient client = this.newElasticsearchClient(config.get("host"), config.get("password"));

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

    private ElasticsearchClient newElasticsearchClient(String host, String apiKey) {
        RestClient restClient = RestClient
            .builder(HttpHost.create(host))
            .setDefaultHeaders(new Header[]{
                new BasicHeader("Authorization", "ApiKey " + apiKey)
            })
            .build();

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
