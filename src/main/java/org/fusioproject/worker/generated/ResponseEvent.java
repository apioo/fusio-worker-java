package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
public class ResponseEvent {
    private String eventName;
    private Object data;
    @JsonSetter("eventName")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    @JsonGetter("eventName")
    public String getEventName() {
        return this.eventName;
    }
    @JsonSetter("data")
    public void setData(Object data) {
        this.data = data;
    }
    @JsonGetter("data")
    public Object getData() {
        return this.data;
    }
}
