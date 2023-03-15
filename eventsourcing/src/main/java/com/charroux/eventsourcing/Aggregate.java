package com.charroux.eventsourcing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("entities")
public abstract class Aggregate extends Entity{

    public abstract List<Event> process(Command cmd);

    public abstract void apply(Event event);

    @Override
    public String toString() {
        return "Aggregate{} " + super.toString();
    }
}
