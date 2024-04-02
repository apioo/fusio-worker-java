package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;
public class Execute {
    private Map<String, ExecuteConnection> connections;
    private ExecuteRequest request;
    private ExecuteContext context;
    @JsonSetter("connections")
    public void setConnections(Map<String, ExecuteConnection> connections) {
        this.connections = connections;
    }
    @JsonGetter("connections")
    public Map<String, ExecuteConnection> getConnections() {
        return this.connections;
    }
    @JsonSetter("request")
    public void setRequest(ExecuteRequest request) {
        this.request = request;
    }
    @JsonGetter("request")
    public ExecuteRequest getRequest() {
        return this.request;
    }
    @JsonSetter("context")
    public void setContext(ExecuteContext context) {
        this.context = context;
    }
    @JsonGetter("context")
    public ExecuteContext getContext() {
        return this.context;
    }
}
