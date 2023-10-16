package com.example.FootballHuB.service.Schedule_service;

import com.example.FootballHuB.dto.Schedule_dto.ScheduleDTO;
import com.example.FootballHuB.entity.schedule_entity.Match;

import com.example.FootballHuB.repository.Schedule_repository.SchduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final SchduleRepository scheduleRepository;


    public List<ScheduleDTO> getAllSchedules(){

        List<ScheduleDTO> ScheduleDtos = new ArrayList<>();
        List<Match> matches = scheduleRepository.findAll();

        for (Match match : matches) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();

            // 엔터티에서 DTO로 데이터 복사 (매핑)
            scheduleDTO.setCompetitionName(match.getCompetitionName());
            scheduleDTO.setDatetime(match.getDatetime());
            scheduleDTO.setHome_Team(match.getHome().getName());
            scheduleDTO.setHome_Emblem_url(match.getHome().getEmblem_url());
            scheduleDTO.setHomeScore(match.getHomeScore());
            scheduleDTO.setAwayScore(match.getAwayScore());
            scheduleDTO.setAway_Emblem_url(match.getAway().getEmblem_url());
            scheduleDTO.setAway_Team(match.getAway().getName());

            List<String> domains = match.getBroadcastProgram().stream()
                    .map(broadcastProgram -> broadcastProgram.getDomain())
                    .collect(Collectors.toList());
            scheduleDTO.setDomain(domains);

            List<String> broadcastnames = match.getBroadcastProgram().stream()
                    .map(broadcastProgram -> broadcastProgram.getBroadcast().getName())
                    .collect(Collectors.toList());
            scheduleDTO.setBroadcastName(broadcastnames);

            ScheduleDtos.add(scheduleDTO);
        }
        return ScheduleDtos;
    }


}