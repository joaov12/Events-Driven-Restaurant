package com.soares.RestaurantKafkaProducer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soares.RestaurantKafkaProducer.entity.Order;
import com.soares.RestaurantKafkaProducer.repository.OrderRepository;
import com.soares.RestaurantKafkaProducer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "topic-orders-integrated", groupId = "group2")
    public void integrateOrder(String data) throws JsonProcessingException {
        System.out.println("MENSAGEM RECEBIDA - Order integrated " + data);

        Order order = objectMapper.readValue(data, Order.class);

        Order UpdatedOrder = orderService.findByCpf(order.getCpf());
        UpdatedOrder.setIntegrated(true);

        orderRepository.save(UpdatedOrder);

    }
}
