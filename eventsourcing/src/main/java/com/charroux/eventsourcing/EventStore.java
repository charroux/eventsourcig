package com.charroux.eventsourcing;

import java.util.List;

public interface EventStore {

    List<Event> findById(String aggregareId);

    void save(List<Event> events);

}
