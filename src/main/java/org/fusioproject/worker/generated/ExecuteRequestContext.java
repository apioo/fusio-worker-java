package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;

public class ExecuteRequestContext {
    private String type;
    private Map<String, String> uriFragments;
    private String method;
    private String path;
    private Map<String, String> queryParameters;
    private Map<String, String> headers;
    @JsonSetter("type")
    public void setType(String type) {
        this.type = type;
    }
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }
    @JsonSetter("uriFragments")
    public void setUriFragments(Map<String, String> uriFragments) {
        this.uriFragments = uriFragments;
    }
    @JsonGetter("uriFragments")
    public Map<String, String> getUriFragments() {
        return this.uriFragments;
    }
    @JsonSetter("method")
    public void setMethod(String method) {
        this.method = method;
    }
    @JsonGetter("method")
    public String getMethod() {
        return this.method;
    }
    @JsonSetter("path")
    public void setPath(String path) {
        this.path = path;
    }
    @JsonGetter("path")
    public String getPath() {
        return this.path;
    }
    @JsonSetter("queryParameters")
    public void setQueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }
    @JsonGetter("queryParameters")
    public Map<String, String> getQueryParameters() {
        return this.queryParameters;
    }
    @JsonSetter("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    @JsonGetter("headers")
    public Map<String, String> getHeaders() {
        return this.headers;
    }
}
