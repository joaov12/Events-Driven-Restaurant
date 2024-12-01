package com.soares.RestaurantKafkaProducer.producer;

import com.soares.RestaurantKafkaProducer.dto.OrderDTO;
import com.soares.RestaurantKafkaProducer.entity.Order;
import com.soares.RestaurantKafkaProducer.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "topic-orders";

    public void send(OrderDTO orderDTO){
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        Message<Order> message = MessageBuilder
                .withPayload(order)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

        System.out.println("PRODUCER: Mensagem Enviada");
        kafkaTemplate.send(message);
    }
}
