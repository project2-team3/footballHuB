package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByMemberId(Long memberId);

    Long countByMemberId(Long memberId);
}