package com.soares.RestaurantKafkaProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaProducerConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name("topic-orders")
                .build();
    }

}
