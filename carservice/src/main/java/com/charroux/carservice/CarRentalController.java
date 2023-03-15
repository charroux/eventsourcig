package com.charroux.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRentalController {

    RentalService rentalService;

    @Autowired
    public CarRentalController(RentalService rentalService) {
        super();
        this.rentalService = rentalService;
    }

    @PostMapping("/")
    public ResponseEntity<RentCarsResponse>  rentCars(@RequestBody RentCarsRequest rentCarsRequest) throws Exception{
        RentalAgreement rentalAgreement = rentalService.rent(
                rentCarsRequest.getCustomerId(),
                rentCarsRequest.getNumberOfCars());
        return new ResponseEntity<>(
                new RentCarsResponse(
                        rentalAgreement.getCustomerId(), rentalAgreement.getId(), "azerty"),
                HttpStatus.OK);
    }
}
