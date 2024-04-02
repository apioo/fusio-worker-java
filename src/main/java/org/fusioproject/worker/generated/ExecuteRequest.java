package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.Map;
public class ExecuteRequest {
    private Map<String, String> arguments;
    private Object payload;
    private ExecuteRequestContext context;
    @JsonSetter("arguments")
    public void setArguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }
    @JsonGetter("arguments")
    public Map<String, String> getArguments() {
        return this.arguments;
    }
    @JsonSetter("payload")
    public void setPayload(Object payload) {
        this.payload = payload;
    }
    @JsonGetter("payload")
    public Object getPayload() {
        return this.payload;
    }
    @JsonSetter("context")
    public void setContext(ExecuteRequestContext context) {
        this.context = context;
    }
    @JsonGetter("context")
    public ExecuteRequestContext getContext() {
        return this.context;
    }
}
