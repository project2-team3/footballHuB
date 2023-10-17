package com.example.FootballHuB.controller.gameController;



import com.example.FootballHuB.entity.gameEntity.GameGift;
import com.example.FootballHuB.service.gameService.GameGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GameController {

    private final GameGiftService gameGiftService;

    @Autowired
    public GameController(GameGiftService gameGiftService) {
        this.gameGiftService = gameGiftService;
    }

    @GetMapping("/game")
    public String showRoulette(HttpServletRequest request, Authentication authentication,Model model) {
        if (authentication != null) {
            String username = authentication.getName();
            request.getSession().setAttribute("username", username);
            System.out.println("Logged in username: " + username);
        }
        List<GameGift> giftsList = gameGiftService.getAllGameGifts();
        model.addAttribute("giftsList", giftsList);

        // GiftList 데이터 확인을 위한 로그 출력
        System.out.println("Gift List: " + giftsList);

        return "roulette.html";
    }
}

