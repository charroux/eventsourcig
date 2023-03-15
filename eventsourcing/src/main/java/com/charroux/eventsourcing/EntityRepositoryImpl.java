package com.charroux.eventsourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Repository
public class EntityRepositoryImpl implements EntityRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Entity> getAllEntities() {
        return mongoTemplate.findAll(Entity.class);
    }

    @Override
    public List<Entity> getAllEntitiesByEntityType(Class entityType) {
        Query query = new Query();
        return mongoTemplate.find(query, entityType);
    }

    @Override
    public Entity getEntityById(String entityId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("entityId").is(entityId));
        return mongoTemplate.findOne(query, Entity.class);
    }

    @Override
    public Entity save(Entity entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public Aggregate save(Class entityClass, Command command) {

        /*if(aggregateClass.isAssignableFrom(Aggregate.class) == false){
            throw new IllegalArgumentException("Aggregate class excepted");
        }*/

        Aggregate aggregate = null;
        try {
            aggregate = (Aggregate) entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<Event> events = aggregate.process(command);
        Aggregate finalAggregate = aggregate;
        events.stream().forEach(event -> finalAggregate.apply(event));

        System.out.println("save");

        mongoTemplate.save(aggregate);

        return aggregate;
    }
}
