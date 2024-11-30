package com.soares.RestaurantKafkaConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class RestaurantKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantKafkaConsumerApplication.class, args);
	}

}
