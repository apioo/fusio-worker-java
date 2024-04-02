package org.fusioproject.worker.generated;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;
public class Response {
    private ResponseHTTP response;
    private List<ResponseEvent> events;
    private List<ResponseLog> logs;
    @JsonSetter("response")
    public void setResponse(ResponseHTTP response) {
        this.response = response;
    }
    @JsonGetter("response")
    public ResponseHTTP getResponse() {
        return this.response;
    }
    @JsonSetter("events")
    public void setEvents(List<ResponseEvent> events) {
        this.events = events;
    }
    @JsonGetter("events")
    public List<ResponseEvent> getEvents() {
        return this.events;
    }
    @JsonSetter("logs")
    public void setLogs(List<ResponseLog> logs) {
        this.logs = logs;
    }
    @JsonGetter("logs")
    public List<ResponseLog> getLogs() {
        return this.logs;
    }
}
