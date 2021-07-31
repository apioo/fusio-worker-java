package org.fusioproject.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fusioproject.worker.generated.Event;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private final List<Event> events = new ArrayList<Event>();
    private final ObjectMapper objectMapper;

    public Dispatcher() {
        this.objectMapper = new ObjectMapper();
    }

    public void dispatch(String eventName, Object data) throws JsonProcessingException {
        this.events.add(new Event(eventName, this.objectMapper.writeValueAsString(data)));
    }

    public List<Event> getEvents() {
        return this.events;
    }
}
