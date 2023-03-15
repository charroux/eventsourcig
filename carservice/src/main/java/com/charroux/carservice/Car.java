package com.charroux.carservice;

import com.charroux.eventsourcing.Command;
import com.charroux.eventsourcing.Entity;
import com.charroux.eventsourcing.Event;

import java.util.List;

public class Car extends Entity {

    String plateNumber;
    String brand;
    int price;
    String rentalAgreementId;

    public Car() { }

    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRentalAgreementId() {
        return rentalAgreementId;
    }

    public void setRentalAgreementId(String rentalAgreementId) {
        this.rentalAgreementId = rentalAgreementId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", rentalAgreementId='" + rentalAgreementId + '\'' +
                "} " + super.toString();
    }
}
