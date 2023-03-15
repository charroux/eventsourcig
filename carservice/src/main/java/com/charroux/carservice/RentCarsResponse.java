package com.charroux.carservice;

public class RentCarsResponse {

    String customerID;
    String rentalAgreementId;
    String state;

    public RentCarsResponse() { }

    public RentCarsResponse(String customerID, String rentalAgreementId, String state) {
        this.customerID = customerID;
        this.rentalAgreementId = rentalAgreementId;
        this.state = state;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRentalAgreementId() {
        return rentalAgreementId;
    }

    public void setRentalAgreementId(String rentalAgreementId) {
        this.rentalAgreementId = rentalAgreementId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
