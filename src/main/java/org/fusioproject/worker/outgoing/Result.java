package org.fusioproject.worker.outgoing;

import java.util.List;

public class Result {
    private final Response response;
    private final List<Event> events;
    private final List<Log> logs;

    public Result(Response response, List<Event> events, List<Log> logs) {
        this.response = response;
        this.events = events;
        this.logs = logs;
    }

    public Response getResponse() {
        return response;
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Log> getLogs() {
        return logs;
    }
}
