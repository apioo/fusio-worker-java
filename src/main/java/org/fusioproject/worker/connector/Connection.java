package org.fusioproject.worker.connector;

import java.util.Map;

public class Connection {
    private String type;
    private Map<String, String> config;

    public Connection() {
    }

    public Connection(String type, Map<String, String> config) {
        this.type = type;
        this.config = config;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}
