package com.charroux.eventsourcing;

import java.util.List;

public interface AggregateDAL {

    List<Aggregate> getAllAggregates();

    Aggregate getAggregateById(String aggregateId);

    Aggregate addNewAggregate(Aggregate aggregate);

}
