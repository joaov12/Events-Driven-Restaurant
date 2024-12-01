package com.soares.RestaurantKafkaProducer.service;

import com.soares.RestaurantKafkaProducer.dto.OrderDTO;
import com.soares.RestaurantKafkaProducer.entity.Order;
import com.soares.RestaurantKafkaProducer.mapper.OrderMapper;
import com.soares.RestaurantKafkaProducer.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void saveOrder(OrderDTO orderDTO){
        Order order = OrderMapper.INSTANCE.toEntity(orderDTO);
        orderRepository.save(order);
    }

    public Order findByCpf(String cpf) {
        return orderRepository.findByCpf(cpf);
    }
}
