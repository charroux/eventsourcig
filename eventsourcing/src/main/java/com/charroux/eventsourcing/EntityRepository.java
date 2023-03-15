package com.charroux.eventsourcing;

import java.util.List;

public interface EntityRepository {

    List<Entity> getAllEntities();

    List<Entity> getAllEntitiesByEntityType(Class entityType);

    Entity getEntityById(String entityId);

    Entity save(Entity entity);
    Aggregate save(Class entityClass, Command command);

}
