package com.example.FootballHuB.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/shop")
public class ShopController {
    @GetMapping
    public String shopMain(){
        return "shop/main";
    }

    @GetMapping(value = "/test")
    public String testMain(){
        return "shop/main-copy";
    }
}