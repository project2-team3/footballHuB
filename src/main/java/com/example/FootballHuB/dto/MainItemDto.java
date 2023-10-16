package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Category;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainItemDto {

    private Long id;

    private String itemNm;

    private String itemDetail;

    private String imgUrl;

    private Integer price;

    private Category category;

    private double rating;

//    private Long rating;

    @QueryProjection
    public MainItemDto(Long id, String itemNm, String itemDetail, String imgUrl,Integer price, Category category){
        this.id = id;
        this.itemNm = itemNm;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
        this.category = category;
//        this.rating = rating;
    }

}