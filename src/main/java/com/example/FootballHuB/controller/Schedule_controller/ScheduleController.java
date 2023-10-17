package com.example.FootballHuB.controller.Schedule_controller;

import com.example.FootballHuB.dto.Schedule_dto.ScheduleDTO;
import com.example.FootballHuB.service.Schedule_service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @GetMapping(value = "/schedules")
    public String Schedule(Model model) {
        List<ScheduleDTO> ScheduleDtos = scheduleService.getAllSchedules();
        model.addAttribute("ScheduleDtos", ScheduleDtos);
        System.out.println(ScheduleDtos);
        return "Main";
    }


    // REST 엔드포인트 및 요청 처리 메서드 추가
}
