package com.charroux.carservice;

import com.charroux.eventsourcing.Event;

public class AgreementCreatedEvent extends Event {

    String customerId;
    int numberOfCars;
    int price;

    public AgreementCreatedEvent(String entityType, long entityId, String eventType, String customerId, int numberOfCars, int price) {
        super(entityType, entityId, eventType);
        this.customerId = customerId;
        this.numberOfCars = numberOfCars;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
