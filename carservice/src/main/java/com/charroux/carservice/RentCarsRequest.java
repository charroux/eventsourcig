package com.charroux.carservice;

public class RentCarsRequest {

    String customerId;
    int numberOfCars;

    public RentCarsRequest() {
    }

    public RentCarsRequest(String customerId, int numberOfCars) {
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

    @Override
    public String toString() {
        return "RentCarsRequest{" +
                "customerId='" + customerId + '\'' +
                ", numberOfCars=" + numberOfCars +
                '}';
    }
}
