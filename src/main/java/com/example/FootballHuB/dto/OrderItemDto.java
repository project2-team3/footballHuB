package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {

    public OrderItemDto(OrderItem orderItem, String imgUrl, String grade){
        this.id = orderItem.getId();
        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
        this.grade = grade;
    }

    private Long id;
    private String itemNm; //상품명
    private int count; //주문 수량
    private String grade;

    private int orderPrice; //주문 금액
    private String imgUrl; //상품 이미지 경로

}