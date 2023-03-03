package com.charroux.eventsourcing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class AggregateRepository<Aggregate, Command>  {

    private final Class<Aggregate> aggregateClass;

    public AggregateRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        aggregateClass = (Class) pt.getActualTypeArguments()[0];
    }

    private Aggregate createInstance() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return aggregateClass.getDeclaredConstructor().newInstance();
    }

    public Entity<Aggregate> findById(long id) {
        try {
            Aggregate aggregate = this.createInstance();
            return new Entity<>(aggregate);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Aggregate save(Command cmd) {
        Aggregate aggregate = null;
        try {
            aggregate = this.createInstance();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        /*List<Event> events = aggregate.processCommand(cmd);
        Aggregates.applyEvents(aggregate, events);
        return new Entity(
                aggregateStore.save(clasz, events),
                aggregate);*/
        return null;
    }
}
