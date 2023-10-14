package com.shop.repository;

import com.shop.entity.Order;
import com.shop.entity.Rating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByMemberIdAndOrderItemId(Long memberId, Long orderItemId);
    List<Rating> findByOrderItemId(Long orderItemId);

}
