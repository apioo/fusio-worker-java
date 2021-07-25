package org.fusioproject.worker;

import org.fusioproject.worker.outgoing.Event;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private final List<Event> events = new ArrayList<Event>();

    public void dispatch(String eventName, Object data) {
        this.events.add(new Event(eventName, data));
    }

    public List<Event> getEvents() {
        return this.events;
    }
}
