package com.charroux.eventsourcing;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("aggregates")
public class Aggregate <Type, Command>{

    @Id
    private String id;

    public List<Event> process(Command cmd){
        return null;
    }

    public void apply(Event event){
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "id='" + id + '\'' +
                '}';
    }
}
