package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findByMemberIdAndOrderItemId(Long memberId, Long orderItemId);
    List<Rating> findByOrderItemId(Long orderItemId);

}
