package org.fusioproject.worker;

import org.fusioproject.worker.generated.ResponseEvent;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private final List<ResponseEvent> events = new ArrayList<>();

    public void dispatch(String eventName, Object data) {
        ResponseEvent event = new ResponseEvent();
        event.setEventName(eventName);
        event.setData(data);

        this.events.add(event);
    }

    public List<ResponseEvent> getEvents() {
        return this.events;
    }
}
