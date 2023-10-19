package com.example.FootballHuB.controller.shop;

import com.example.FootballHuB.dto.CategoryDto;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.repository.CartRepository;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.OrderRepository;
import com.example.FootballHuB.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.example.FootballHuB.dto.ItemFormDto;

import com.example.FootballHuB.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.EntityNotFoundException;

import com.example.FootballHuB.dto.ItemSearchDto;
import com.example.FootballHuB.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    private final CartRepository cartRepository;

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;


    @GetMapping(value = "/shop/admin/item/new")
    public String itemForm(Model model){

        List<CategoryDto> categoryDtoList = categoryService.getAllCategory();

        model.addAttribute("itemFormDto", new ItemFormDto());
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "shop/item/itemForm";
    }

    @PostMapping(value = "/shop/admin/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                          Model model, @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList){
        if(bindingResult.hasErrors()){
            return "shop/item/itemForm";
        }

        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "shop/item/itemForm";
        }

        try {
            itemService.saveItem(itemFormDto, itemImgFileList);
        } catch (Exception e){
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "shop/item/itemForm";
        }

        return "redirect:/shop";
    }

    @GetMapping(value = "/shop/admin/item/{itemId}")
    public String itemDtl(@PathVariable("itemId") Long itemId, Model model){

        try {
            ItemFormDto itemFormDto = itemService.getItemDtl(itemId);
            model.addAttribute("itemFormDto", itemFormDto);
        } catch(EntityNotFoundException e){
            model.addAttribute("errorMessage", "존재하지 않는 상품 입니다.");
            model.addAttribute("itemFormDto", new ItemFormDto());
            return "shop/item/itemForm";
        }

        return "shop/item/itemForm";
    }

    @PostMapping(value = "/shop/admin/item/{itemId}")
    public String itemUpdate(@Valid ItemFormDto itemFormDto, BindingResult bindingResult,
                             @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList, Model model){
        if(bindingResult.hasErrors()){
            return "shop/item/itemForm";
        }

        if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
            return "shop/item/itemForm";
        }

        try {
            itemService.updateItem(itemFormDto, itemImgFileList);
        } catch (Exception e){
            model.addAttribute("errorMessage", "상품 수정 중 에러가 발생하였습니다.");
            return "shop/item/itemForm";
        }

        return "redirect:/shop";
    }

    @GetMapping(value = {"/shop/admin/items", "/shop/admin/items/{page}"})
    public String itemManage(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model){

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
        Page<Item> items = itemService.getAdminItemPage(itemSearchDto, pageable);

        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);

        return "shop/item/itemMng";
    }

    @GetMapping(value = "/shop/item/{itemId}")
    public String itemDtl(Model model, @PathVariable("itemId") Long itemId, Principal principal){
        ItemFormDto itemFormDto = itemService.getItemDtl(itemId);

        List<CategoryDto> categoryDtoList =  categoryService.getAllCategory();
        long cartCount = 0;
        long orderCount = 0;
        if(principal != null) {
            Member member = memberRepository.findByEmail(principal.getName());
            if(member != null) {
                cartCount = cartRepository.countByMemberId(member.getId());
                orderCount = orderRepository.countByMemberId(member.getId());
            }
        }

        model.addAttribute("cartCount", cartCount);
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("item", itemFormDto);
        return "shop/item/itemDtl";
    }

}