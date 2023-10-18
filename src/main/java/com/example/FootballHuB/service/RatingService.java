package com.example.FootballHuB.service;

import com.example.FootballHuB.dto.RatingDto;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.entity.OrderItem;
import com.example.FootballHuB.entity.Rating;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.OrderItemRepository;
import com.example.FootballHuB.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final MemberRepository memberRepository;
    private final OrderItemRepository orderItemRepository;
    public Long addRating(RatingDto ratingDto, String email) {
        Member member = memberRepository.findByEmail(email);
        Rating findRating = ratingRepository.findByMemberIdAndOrderItemId(member.getId(), ratingDto.getOrderItemId());
        if (findRating == null) {
            OrderItem orderItem = orderItemRepository.findById(ratingDto.getOrderItemId())
                    .orElseThrow(EntityNotFoundException::new);
            Rating newRating = Rating.createRating(member, orderItem, ratingDto.getGrade());
            ratingRepository.save(newRating);
            return newRating.getId();
        } else {
            findRating.updateRating(ratingDto);
            return findRating.getId();
        }
    }

    public double getAveByItemId(Long itemId) {
        double sum = 0;
        int count = 0;
        List<OrderItem> orderItemList = orderItemRepository.findByItemId(itemId);
        for (OrderItem orderItem : orderItemList) {
            List<Rating> ratingList = ratingRepository.findByOrderItemId(orderItem.getId());
            for (Rating rating : ratingList) {
                sum += Integer.parseInt(rating.getGrade());
                count++;
            }
        }

        return sum/count;
    }
}
