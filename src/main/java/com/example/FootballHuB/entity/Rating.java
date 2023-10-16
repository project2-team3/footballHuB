package com.example.FootballHuB.entity;

import com.example.FootballHuB.dto.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="rating")
@Getter
@Setter
@ToString
public class Rating extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="rating_id")
    private Long id;

    @Column(nullable = false)
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    public static Rating createRating(Member member, OrderItem orderItem, String grade) {
        Rating rating = new Rating();
        rating.setMember(member);
        rating.setGrade(grade);
        rating.setOrderItem(orderItem);
        return rating;
    }

    public void updateRating(RatingDto ratingDto) {
        this.grade = ratingDto.getGrade();
    }
}

