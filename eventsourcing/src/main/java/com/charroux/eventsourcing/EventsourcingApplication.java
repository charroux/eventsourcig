package com.charroux.eventsourcing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventsourcingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsourcingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			Essai essai = new Essai();
			essai.essai();
		};
	}

}
