package com.example.FootballHuB.repository;

import com.example.FootballHuB.dto.ItemSearchDto;
import com.example.FootballHuB.dto.MainItemDto;
import com.example.FootballHuB.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}