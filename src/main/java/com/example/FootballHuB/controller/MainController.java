package com.example.FootballHuB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.FootballHuB.service.ItemService;
import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    @GetMapping(value = "/")
    public String main(){
        return "main";
    }

}