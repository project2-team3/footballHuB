package com.example.FootballHuB.controller.shop;
import com.example.FootballHuB.dto.CategoryDto;
import com.example.FootballHuB.dto.ItemSearchDto;
import com.example.FootballHuB.dto.MainItemDto;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.entity.Order;
import com.example.FootballHuB.repository.CartRepository;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.OrderRepository;
import com.example.FootballHuB.service.CategoryService;
import com.example.FootballHuB.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ShopController {
    private final ItemService itemService;

    private final CategoryService categoryService;

    private final CartRepository cartRepository;

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    @GetMapping(value = "/shop")
    public String shopMain(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model,HttpServletRequest request, HttpSession session, Principal principal){

        String nowPage = request.getRequestURL().toString();
        request.getSession().setAttribute("nowPage", nowPage);
        System.out.println(session.getAttribute("nowPage"));

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);

        List<CategoryDto> categoryDtoList =  categoryService.getAllCategory();
        long cartCount = 0;
        long orderCount = 0;
        if(principal != null) {
            Member member = memberRepository.findByEmail(principal.getName());
            if(member != null) {
                cartCount = cartRepository.countByMemberId(member.getId());
                orderCount = orderRepository.countByMemberId(member.getId());
            }
            System.out.println(cartCount);
        }

        model.addAttribute("cartCount", cartCount);
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("categoryDtoList", categoryDtoList);
        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);

        return "shop/main";
    }
}