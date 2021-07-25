package org.fusioproject.worker.connector;

import java.util.HashMap;

public class Connection {
    private final String type;
    private final HashMap<String, String> config;

    public Connection(String type, HashMap<String, String> config) {
        this.type = type;
        this.config = config;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, String> getConfig() {
        return config;
    }
}
