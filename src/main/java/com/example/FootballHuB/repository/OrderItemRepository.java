package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByItemId(Long itemId);
}