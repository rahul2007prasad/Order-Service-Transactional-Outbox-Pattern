package com.rahul.transactional.pattern.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.transactional.pattern.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
