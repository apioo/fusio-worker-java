package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;
public class ResponseHTTP {
    private Integer statusCode;
    private Map<String, String> headers;
    private Object body;
    @JsonSetter("statusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    @JsonGetter("statusCode")
    public Integer getStatusCode() {
        return this.statusCode;
    }
    @JsonSetter("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    @JsonGetter("headers")
    public Map<String, String> getHeaders() {
        return this.headers;
    }
    @JsonSetter("body")
    public void setBody(Object body) {
        this.body = body;
    }
    @JsonGetter("body")
    public Object getBody() {
        return this.body;
    }
}
