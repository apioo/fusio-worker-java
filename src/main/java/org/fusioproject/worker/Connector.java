package org.fusioproject.worker;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.fusioproject.worker.connector.Connection;
import org.fusioproject.worker.connector.Connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Connector {
    private final Connections connections;
    private HashMap<String, Object> instances;

    public Connector(Connections connections) {
        this.connections = connections;
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
            if (connection.getConfig().get("type").equals("pdo_mysql")) {
                java.sql.Connection con = this.newSqlConnection("mysql://" + connection.getConfig().get("host") + ":3306/" + connection.getConfig().get("database") + "?user=" + connection.getConfig().get("username") + "&password=" + connection.getConfig().get("password"));

                this.instances.put(name, con);

                return con;
            } else {
                throw new RuntimeException("SQL type is not supported");
            }
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
}
