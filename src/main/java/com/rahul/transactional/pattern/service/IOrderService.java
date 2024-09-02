package com.rahul.transactional.pattern.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rahul.transactional.pattern.common.OrderDto;
import com.rahul.transactional.pattern.entity.Order;

public interface IOrderService {

	public Order createOrder(OrderDto orderDto) throws JsonProcessingException ;
}
