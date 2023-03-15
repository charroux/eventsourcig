package com.charroux.carservice;

import com.charroux.eventsourcing.Event;
import com.charroux.eventsourcing.EventStoreImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CarRentalEventStore extends EventStoreImpl {
    @Override
    public void handleMessage(byte[] message) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Event event = objectMapper.readValue(message, Event.class);

        switch (event.getEntityType()){
            case "RentalAgreement":
                RentalAgreement rentalAgreement = objectMapper.convertValue(event.getData(), new TypeReference<RentalAgreement>() {});
                System.out.println("rentalAgreement = " + rentalAgreement);
                //rentalAgreement.getCars().stream().forEach(car -> System.out.println(car));
                break;
            case "CustomerApplication":
                //CustomerApplication customerApplication = objectMapper.convertValue(event.getData(), new TypeReference<CustomerApplication>() {});
                //System.out.println("consumerApplication = " + customerApplication);
                break;
            default:
        }

    }
}
