package com.charroux.carservice;

import com.charroux.eventsourcing.Event;

import java.util.Collection;
import java.util.HashSet;

public class CarAddedEvent extends Event {

    String agreementId;
    String customerId;
    Collection<String> carsId;

    public CarAddedEvent(String agreementId, String customerId, Collection<String> carsId) {
        this.agreementId = agreementId;
        this.customerId = customerId;
        this.carsId = carsId;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Collection<String> getCarsId() {
        return carsId;
    }

    public void setCarsId(Collection<String> carsId) {
        this.carsId = carsId;
    }
}
