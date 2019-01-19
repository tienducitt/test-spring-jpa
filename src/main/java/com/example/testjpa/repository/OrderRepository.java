package com.example.testjpa.repository;

import com.example.testjpa.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM orders o WHERE o.id IN ?1")
    List<Order> findByIds(List<Integer> ids);

    @Query("SELECT o FROM orders o WHERE o.name = ?1")
    Order findByName(String name);
}
