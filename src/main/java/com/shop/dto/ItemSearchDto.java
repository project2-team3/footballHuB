package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemSearchDto {

    private String category;

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";

}