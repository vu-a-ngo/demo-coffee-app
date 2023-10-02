package com.demo.coffee.app.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.coffee.app.jpa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
