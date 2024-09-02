package com.rahul.transactional.pattern.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.rahul.transactional.pattern.common.OrderDto;
import com.rahul.transactional.pattern.entity.Order;

@Component
public class OrderDtoToEntityMapper {

	public Order map(OrderDto orderDto) {
		return Order.builder()
		.customerId(orderDto.getCustomerId())
		.name(orderDto.getName())
		.productType(orderDto.getProductType())
		.quantity(orderDto.getQuantity())
		.price(orderDto.getPrice())
		.orderDate(new Date())
		.build();
		
	}
}
