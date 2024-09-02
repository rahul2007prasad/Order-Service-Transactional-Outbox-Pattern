package com.rahul.transactional.pattern.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.transactional.pattern.entity.Outbox;

public interface OutBoxRepo extends JpaRepository<Outbox, Long>{

}
