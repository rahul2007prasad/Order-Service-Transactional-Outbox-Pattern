package com.rahul.transactional.pattern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rahul.transactional.pattern.common.OrderDto;
import com.rahul.transactional.pattern.entity.Order;
import com.rahul.transactional.pattern.entity.Outbox;
import com.rahul.transactional.pattern.mapper.OrderDtoToEntityMapper;
import com.rahul.transactional.pattern.mapper.OrderEntityToOutBoxEntityMapper;
import com.rahul.transactional.pattern.repo.OrderRepo;
import com.rahul.transactional.pattern.repo.OutBoxRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderDtoToEntityMapper orderDtoToEntityMapper;
	
	@Autowired
	private OutBoxRepo outBoxRepo;
	
	
	@Autowired
	private OrderEntityToOutBoxEntityMapper outBoxEntityMapper;
	
	
	@Transactional
	public Order createOrder(OrderDto orderDto) throws JsonProcessingException {
		
		System.out.println(orderDto.toString());
		Order order = orderDtoToEntityMapper.map(orderDto);
		
		Order savedOrder = orderRepo.save(order);
		Outbox outboxMapped = outBoxEntityMapper.map(savedOrder);
		
		 outBoxRepo.save(outboxMapped);
		
		return order;
	}
	
	
}
