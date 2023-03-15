package com.charroux.carservice;

import com.charroux.eventsourcing.Command;

public class CreateAgreementCommand extends Command {

    String customerId;
    int numberOfCars;
    int price;

    public CreateAgreementCommand(String customerId, int numberOfCars) {
        this.customerId = customerId;
        this.numberOfCars = numberOfCars;
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
