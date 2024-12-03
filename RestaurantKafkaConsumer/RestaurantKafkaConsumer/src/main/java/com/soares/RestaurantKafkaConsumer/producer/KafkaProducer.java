package com.soares.RestaurantKafkaConsumer.producer;

import com.soares.RestaurantKafkaConsumer.config.TopicConfig;
import com.soares.RestaurantKafkaConsumer.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Order>  kafkaTemplate;

    private static final String TOPIC = "topic-orders-integrated";

    public void send(Order order){
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

        System.out.println("PRODUCER: Mensagem Enviada (Order integraded)");
        kafkaTemplate.send(message);
    }
}
