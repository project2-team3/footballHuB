package com.example.FootballHuB.controller.Schedule_controller;

import com.example.FootballHuB.dto.Schedule_dto.ScheduleDTO;
import com.example.FootballHuB.service.Schedule_service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/")
    public String Schedule(Model model, Authentication authentication) {
        List<ScheduleDTO> ScheduleDtos = scheduleService.getAllSchedules();
        model.addAttribute("ScheduleDtos", ScheduleDtos);
        System.out.println(ScheduleDtos);
        return "Main";
    }


}
