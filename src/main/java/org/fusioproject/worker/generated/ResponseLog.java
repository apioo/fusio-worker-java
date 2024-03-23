package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ResponseLog {
    private String level;
    private String message;
    @JsonSetter("level")
    public void setLevel(String level) {
        this.level = level;
    }
    @JsonGetter("level")
    public String getLevel() {
        return this.level;
    }
    @JsonSetter("message")
    public void setMessage(String message) {
        this.message = message;
    }
    @JsonGetter("message")
    public String getMessage() {
        return this.message;
    }
}
