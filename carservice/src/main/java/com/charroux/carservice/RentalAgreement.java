package com.charroux.carservice;

import com.charroux.eventsourcing.Aggregate;
import com.charroux.eventsourcing.Command;
import com.charroux.eventsourcing.Event;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class RentalAgreement extends Aggregate {

    String customerId;
    int numberOfCars;
    int price;

    Collection<String> carsId = new HashSet<String>();

    public RentalAgreement() { }

    public RentalAgreement(String customerId, int numberOfCars) {
        this.customerId = customerId;
        this.numberOfCars = numberOfCars;
    }

    @Override
    public List<Event> process(Command command) {
        List<Event> events = null;
        if(command instanceof CreateAgreementCommand){
            events = this.process((CreateAgreementCommand)command);
        }
        return events;
    }

    public List<Event> process(CreateAgreementCommand command){
        this.customerId = command.getCustomerId();
        this.numberOfCars = command.getNumberOfCars();
        this.price = command.getPrice();
        return List.of(new AgreementCreatedEvent(
            "RentalAgreement",

        long entityId, String eventType, String customerId, int numberOfCars, int pricecustomerId, numberOfCars, price));
    }

    public void apply(Event event){
        if(event instanceof AgreementCreatedEvent){
            this.apply((AgreementCreatedEvent)event);
        } else if(event instanceof CarAddedEvent){
            this.apply((CarAddedEvent)event);
        }
    }

    public void apply(AgreementCreatedEvent event){

    }

    public void apply(CarAddedEvent event){
        event.getCarsId().stream().forEach(carToRentId -> this.carsId.add(carToRentId));
        //event.getCarsId().stream().forEach(id -> );
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public Collection<String> getCarsId() {
        return carsId;
    }

    public void setCarsId(Collection<String> carsId) {
        this.carsId = carsId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RA{" +
                "customerId='" + customerId + '\'' +
                ", numberOfCars=" + numberOfCars +
                ", price=" + price +
                ", carsId=" + carsId +
                "} " + super.toString();
    }
}
