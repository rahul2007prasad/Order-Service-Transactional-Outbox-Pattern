package com.rahul.transactional.pattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rahul.transactional.pattern.common.OrderDto;
import com.rahul.transactional.pattern.entity.Order;
import com.rahul.transactional.pattern.service.IOrderService;



@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException{
		System.out.println("in cont " + orderDto.toString());
		Order createdOrder = orderService.createOrder(orderDto);
		return new ResponseEntity<>(createdOrder , HttpStatus.CREATED);
	}
}
