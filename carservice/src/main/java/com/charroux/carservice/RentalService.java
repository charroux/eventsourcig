package com.charroux.carservice;

import java.util.List;

public interface RentalService {
    public RentalAgreement rent(String customerId, int numberOfCars) throws CarNotFoundException;
    public List<Car> carsToBeRented();
    public List<RentalAgreement> getAgreements();
}