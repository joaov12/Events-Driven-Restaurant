package com.soares.RestaurantKafkaProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class RestaurantKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantKafkaProducerApplication.class, args);
	}

}
