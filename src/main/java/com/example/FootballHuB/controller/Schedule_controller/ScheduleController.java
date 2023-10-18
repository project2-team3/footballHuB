package com.example.FootballHuB.controller.Schedule_controller;

import com.example.FootballHuB.dto.Schedule_dto.ScheduleDTO;
import com.example.FootballHuB.service.Schedule_service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @GetMapping(value = "/")
    public String Schedule(Model model, Authentication authentication, HttpServletRequest request, HttpSession session) {
        String nowPage = request.getRequestURL().toString();
        request.getSession().setAttribute("nowPage", nowPage);
        System.out.println(session.getAttribute("nowPage"));
        //사용자가 로그인한 경우에만 사용자 정보를 가져와 모델에 추가
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
        }
        List<ScheduleDTO> ScheduleDtos = scheduleService.getAllSchedules();
        model.addAttribute("ScheduleDtos", ScheduleDtos);
        System.out.println(ScheduleDtos);
        return "Main";
    }


    // REST 엔드포인트 및 요청 처리 메서드 추가
}
