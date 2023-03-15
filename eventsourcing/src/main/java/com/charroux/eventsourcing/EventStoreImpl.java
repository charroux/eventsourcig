package com.charroux.eventsourcing;

import com.charroux.stream.EventConsumer;
import com.charroux.stream.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public abstract class EventStoreImpl extends EventConsumer implements EventStore {

    EventPublisher eventPublisher;

    public EventStoreImpl(){
        this.eventPublisher = new EventPublisher();

    }
    @Override
    public List<Event> findById(String aggregareId) {
        return null;
    }

    @Override
    public void save(List<Event> events) {

        events.stream().forEach(event -> {
            try {
                eventPublisher.publish(
                    new ObjectMapper().writeValueAsBytes(event));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

    }


}
