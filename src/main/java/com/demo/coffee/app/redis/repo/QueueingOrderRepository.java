package com.demo.coffee.app.redis.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.coffee.app.redis.model.QueueingOrder;

@Repository
public interface QueueingOrderRepository extends CrudRepository<QueueingOrder, String> {
}
