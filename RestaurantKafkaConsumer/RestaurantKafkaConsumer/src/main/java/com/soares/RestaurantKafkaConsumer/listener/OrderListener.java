package com.soares.RestaurantKafkaConsumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soares.RestaurantKafkaConsumer.entity.Order;
import com.soares.RestaurantKafkaConsumer.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaProducer kafkaProducer;

    @KafkaListener(topics = "topic-orders", groupId = "group1")
    public void processOrder(String data) throws JsonProcessingException {
        System.out.println("CONSUMER: Mensagem recebida: " + data);

        Order order = objectMapper.readValue(data, Order.class);

        if(order.getId() == null){
            order.setId(System.currentTimeMillis()); // Definindo um ID temporario - ID Gerado apenas quando é persistido
        }

        order.setIntegrated(true);

        kafkaProducer.send(order);
    }

}
