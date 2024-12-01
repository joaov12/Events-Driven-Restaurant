package com.soares.RestaurantKafkaProducer.controller;

import com.soares.RestaurantKafkaProducer.dto.OrderDTO;
import com.soares.RestaurantKafkaProducer.producer.KafkaProducer;
import com.soares.RestaurantKafkaProducer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<String> sendOrder(@RequestBody OrderDTO order){
        orderService.saveOrder(order);
        kafkaProducer.send(order);
        return ResponseEntity.ok("Success");
    }
}
