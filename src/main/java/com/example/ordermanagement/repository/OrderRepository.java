package com.example.ordermanagement.repository;
import com.example.ordermanagement.entitys.Order;
import com.example.ordermanagement.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;



@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}

