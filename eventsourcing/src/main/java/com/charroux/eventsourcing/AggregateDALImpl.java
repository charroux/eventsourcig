package com.charroux.eventsourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class AggregateDALImpl implements AggregateDAL{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Aggregate> getAllAggregates() {
        return mongoTemplate.findAll(Aggregate.class);
    }

    @Override
    public Aggregate getAggregateById(String aggregateId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("aggregateId").is(aggregateId));
        return mongoTemplate.findOne(query, Aggregate.class);
    }

    @Override
    public Aggregate addNewAggregate(Aggregate aggregate) {
        mongoTemplate.save(aggregate);
        return aggregate;
    }
}
