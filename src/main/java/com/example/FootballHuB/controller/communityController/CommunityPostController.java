package com.example.FootballHuB.controller.communityController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gall")
@Controller
@RequiredArgsConstructor
public class CommunityPostController {

    @GetMapping("write")
    public String post(Model model){
        return "community/write";
    }
}
