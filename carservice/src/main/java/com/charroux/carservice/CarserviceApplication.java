package com.charroux.carservice;

import com.charroux.eventsourcing.*;
import com.charroux.stream.EventConsumer;
import com.charroux.stream.EventPublisher;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class CarserviceApplication {

	Logger logger = LoggerFactory.getLogger(CarserviceApplication.class);

	@Bean
	public EntityRepository entityRepository(){
		return new EntityRepositoryImpl();
	}

	@Bean
	public EventStore eventStore(){
		return new CarRentalEventStore();
	}

	public static void main(String[] args) {
		SpringApplication.run(CarserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EntityRepository entityRepository) {
		return (args) -> {

			Car car = new Car("11AA22", "Ferrari", 1000);
			entityRepository.save(car);
			car = new Car("22BB33", "Porshe", 1000);
			entityRepository.save(car);
			car = new Car("33CC44", "Lamborghini", 1000);
			entityRepository.save(car);
			car = new Car("44DD55", "Mac Laren", 1000);
			entityRepository.save(car);

			logger.info("3 cars added to MongoDb.");

			new EventConsumer() {

				@Override
				public void handleMessage(byte[] message) throws IOException {
					logger.info("Customer service emulator started.");
					ObjectMapper objectMapper = new ObjectMapper();
					Event event = objectMapper.readValue(message, Event.class);
					switch (event.getEntityType()){
						case "RentalAgreement":
							RentalAgreement rentalAgreement = objectMapper.convertValue(event.getData(), new TypeReference<RentalAgreement>() {});
							System.out.println("rentalAgreement = " + rentalAgreement);
							rentalAgreement.getCars().stream().forEach(car -> System.out.println(car));
							break;
						case "CustomerApplication":
							CustomerApplication customerApplication = objectMapper.convertValue(event.getData(), new TypeReference<CustomerApplication>() {});
							System.out.println("consumerApplication = " + customerApplication);
							break;
						default:
					}
				}
			};

			/*CreateAgreementCommand command = new CreateAgreementCommand("Tintin", 2);
			RentalAgreement rentalAgreement = (RentalAgreement)repo.save(RentalAgreement.class, command);

			Car car = new Car("Peugeot", 1000);
			car = (Car) repo.save(car);

			List<Entity> entities = repo.getAllEntities();
			entities.stream().forEach(it -> System.out.println(it));

			Iterator<Entity> it = entities.iterator();
			while (it.hasNext()){
				Entity entity = it.next();
				if(entity instanceof Car){
					System.out.println("car");
				} else if(entity instanceof RentalAgreement){
					System.out.println("RA");
				} else {
					System.out.println(entity);
				}
			}*/

		};
	}

}
