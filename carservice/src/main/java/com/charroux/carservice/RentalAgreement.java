package com.charroux.carservice;

import com.charroux.eventsourcing.Aggregate;

public class RentalAgreement extends Aggregate<RentalAgreement, RentalAgreementCommand> {

    String customerId;

    public RentalAgreement() {
    }

    public RentalAgreement(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "customerId='" + customerId + '\'' +
                "} " + super.toString();
    }
}
