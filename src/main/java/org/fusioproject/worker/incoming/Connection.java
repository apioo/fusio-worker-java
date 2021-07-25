package org.fusioproject.worker.incoming;

import java.util.HashMap;

public class Connection {
    private final String name;
    private final String type;
    private final HashMap<String, String> config;

    public Connection(String name, String type, HashMap<String, String> config) {
        this.name = name;
        this.type = type;
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public HashMap<String, String> getConfig() {
        return config;
    }
}
