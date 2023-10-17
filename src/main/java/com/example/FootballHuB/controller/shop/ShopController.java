package com.example.FootballHuB.controller.shop;
import com.example.FootballHuB.dto.CategoryDto;
import com.example.FootballHuB.dto.ItemSearchDto;
import com.example.FootballHuB.dto.MainItemDto;
import com.example.FootballHuB.service.CategoryService;
import com.example.FootballHuB.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/shop")
public class ShopController {
    private final ItemService itemService;

    private final CategoryService categoryService;

    @GetMapping
    public String shopMain(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);

        List<CategoryDto> categoryDtoList =  categoryService.getAllCategory();
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);
//        System.out.println(items.getContent().get(0).getImgUrl());

        return "shop/main";
    }
}