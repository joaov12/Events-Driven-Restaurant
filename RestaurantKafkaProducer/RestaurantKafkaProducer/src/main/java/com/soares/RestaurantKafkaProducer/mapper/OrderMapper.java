package com.soares.RestaurantKafkaProducer.mapper;

import com.soares.RestaurantKafkaProducer.dto.OrderDTO;
import com.soares.RestaurantKafkaProducer.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "integrated", constant = "false")
    Order toEntity(OrderDTO orderDTO);
}
