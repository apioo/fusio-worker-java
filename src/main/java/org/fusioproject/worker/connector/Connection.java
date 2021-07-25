package org.fusioproject.worker.connector;

import java.util.HashMap;

public class Connection {
    private String type;
    private HashMap<String, String> config;

    public Connection() {
    }

    public Connection(String type, HashMap<String, String> config) {
        this.type = type;
        this.config = config;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getConfig() {
        return config;
    }

    public void setConfig(HashMap<String, String> config) {
        this.config = config;
    }
}
