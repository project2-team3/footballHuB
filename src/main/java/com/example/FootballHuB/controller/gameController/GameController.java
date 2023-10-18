package com.example.FootballHuB.controller.gameController;


import com.example.FootballHuB.entity.Member;
import org.springframework.http.ResponseEntity;
import com.example.FootballHuB.service.MemberService;
import com.example.FootballHuB.entity.gameEntity.GameGift;
import com.example.FootballHuB.service.gameService.GameGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    private final GameGiftService gameGiftService;
    private final MemberService memberService;


    @Autowired
    public GameController(GameGiftService gameGiftService, MemberService memberService) {
        this.gameGiftService = gameGiftService;
        this.memberService = memberService;
    }


    @GetMapping("/game")
    public String showRoulette(HttpServletRequest request, Authentication authentication, Model model) {

        if (authentication != null) {
            String username = authentication.getName();
            request.getSession().setAttribute("username", username);
            System.out.println("Logged in username: " + username);

            Integer spinCount = memberService.getSpinCountByEmail(username);
            model.addAttribute("spinCount", spinCount);
        }

        List<GameGift> giftsList = gameGiftService.getAllGameGifts();
        model.addAttribute("giftsList", giftsList);

        // GiftList 데이터 확인을 위한 로그 출력
        System.out.println("Gift List: " + giftsList);

        return "roulette.html";
    }

    @PostMapping("/update-spin-count")
    public ResponseEntity<String> updateSpinCount(@RequestBody Map<String, Object> requestData) {
        String email = (String) requestData.get("email");
        int updatedSpinCount = Integer.parseInt(requestData.get("spinCount").toString());
        memberService.updateSpinCountByEmail(email, updatedSpinCount);
        System.out.println(email + updatedSpinCount);
        return ResponseEntity.ok("스핀 카운트가 업데이트되었습니다.");
    }

}

