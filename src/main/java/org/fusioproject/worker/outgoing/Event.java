package org.fusioproject.worker.outgoing;

public class Event {
    private final String eventName;
    private final Object data;

    public Event(String eventName, Object data) {
        this.eventName = eventName;
        this.data = data;
    }

    public String getEventName() {
        return eventName;
    }

    public Object getData() {
        return data;
    }
}
