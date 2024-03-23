package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class About {
    private String apiVersion;
    private String language;
    @JsonSetter("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
    @JsonGetter("apiVersion")
    public String getApiVersion() {
        return this.apiVersion;
    }
    @JsonSetter("language")
    public void setLanguage(String language) {
        this.language = language;
    }
    @JsonGetter("language")
    public String getLanguage() {
        return this.language;
    }
}
