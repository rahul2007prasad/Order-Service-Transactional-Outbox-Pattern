package com.rahul.transactional.pattern.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.transactional.pattern.entity.Order;
import com.rahul.transactional.pattern.entity.Outbox;

@Component
public class OrderEntityToOutBoxEntityMapper {

	public Outbox map(Order order) throws JsonProcessingException {
	return	Outbox.builder()
		.aggregateId(order.getId().toString())
		.payload(new ObjectMapper().writeValueAsString(order))
		.cretedAt(new Date())
		.processed(false)
		
		.build();
	}
}
