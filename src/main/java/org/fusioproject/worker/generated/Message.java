package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class Message {
    private Boolean success;
    private String message;
    private String trace;
    @JsonSetter("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    @JsonGetter("success")
    public Boolean getSuccess() {
        return this.success;
    }
    @JsonSetter("message")
    public void setMessage(String message) {
        this.message = message;
    }
    @JsonGetter("message")
    public String getMessage() {
        return this.message;
    }
    @JsonSetter("trace")
    public void setTrace(String trace) {
        this.trace = trace;
    }
    @JsonGetter("trace")
    public String getTrace() {
        return this.trace;
    }
}
