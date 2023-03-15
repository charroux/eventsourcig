package com.charroux.carservice;

import com.charroux.eventsourcing.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService{

    EventStore eventStore;
    EntityRepository entityRepository;

    @Autowired
    public RentalServiceImpl(EventStore eventStore, EntityRepository entityRepository){
        this.eventStore = eventStore;
        this.entityRepository = entityRepository;
    }

    private Aggregate handleCommand(Class aggregateClass, String aggregateId, Command command){
        List<Event> events = eventStore.findById(aggregateId);
        Aggregate aggregate = null;
        try {
            aggregate = (Aggregate) aggregateClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Aggregate finalAggregate = aggregate;
        events.stream().forEach(event -> finalAggregate.apply(event));
        events = aggregate.process(command);
        eventStore.save(events);
        return aggregate;
    }

    @Override
    public RentalAgreement rent(String customerId, int numberOfCars) throws CarNotFoundException {
        CreateAgreementCommand command = new CreateAgreementCommand(customerId, numberOfCars);

        // compute the price for numberOfCars cars
        List<Entity> cars = entityRepository.getAllEntitiesByEntityType(Car.class);
        List<Entity> carsToBeRented = cars.stream().filter(
            entity -> ((Car)entity).getRentalAgreementId()==null)
                .limit(numberOfCars)
                .collect(Collectors.toList());
        Integer amount = carsToBeRented.stream()
            .map(entity -> ((Car)entity).getPrice())
            .collect(Collectors.summingInt(Integer::intValue));

        command.setPrice(amount);
        return (RentalAgreement) this.handleCommand(RentalAgreement.class, null, command);
    }

    @Override
    public List<Car> carsToBeRented() {
        return null;
    }

    @Override
    public List<RentalAgreement> getAgreements() {
        return null;
    }
}
