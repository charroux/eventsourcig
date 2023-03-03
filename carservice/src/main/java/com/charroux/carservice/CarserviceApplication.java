package com.charroux.carservice;

import com.charroux.eventsourcing.Aggregate;
import com.charroux.eventsourcing.AggregateDAL;
import com.charroux.eventsourcing.AggregateDALImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.charroux.eventsourcing.Essai;

import java.util.List;

@SpringBootApplication
public class CarserviceApplication {

	@Bean
	public AggregateDAL aggregateDAL(){
		return new AggregateDALImpl();
	}


	public static void main(String[] args) {
		SpringApplication.run(CarserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AggregateDAL aggregateDAL) {
		return (args) -> {

			Aggregate<RentalAgreement, RentalAgreementCommand> rentalAgreement = new RentalAgreement("Tintin");
			System.out.println(rentalAgreement);
			rentalAgreement = aggregateDAL.addNewAggregate(rentalAgreement);
			System.out.println(rentalAgreement);
			List<Aggregate> aggregates = aggregateDAL.getAllAggregates();
			aggregates.stream().forEach(aggregate -> System.out.println(aggregate));

		};
	}

}
