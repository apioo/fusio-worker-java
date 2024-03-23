package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ExecuteConnection {
    private String type;
    private String config;
    @JsonSetter("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }
    @JsonSetter("config")
    public void setConfig(String config) {
        this.config = config;
    }
    @JsonGetter("config")
    public String getConfig() {
        return this.config;
    }
}
