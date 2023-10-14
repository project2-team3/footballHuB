package com.example.FootballHuB.dto.Schedule_dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter @Setter
public class ScheduleDTO {

    private String competitionName;
    private Date datetime;
    private String Home_Team;
    private String Home_Emblem_url;
    private Integer HomeScore;
    private Integer AwayScore;
    private String Away_Emblem_url;
    private String Away_Team;
    private List<String> Domain;
//    private String Domain;
    private List<String> BroadcastName;


    @Override
    public String toString() {
        return competitionName +" "+ datetime +" "+ Home_Team +" "+ Home_Emblem_url +" | "+ HomeScore +"-"+ AwayScore +" | "+ Away_Emblem_url +" "+ Away_Team +" "+ Domain +" "+ BroadcastName;}


//    public void getScheduleDTO(String competitionName,Date daytime,String team1,Blob team1_emblem,String homeScore,String awayScore,Blob team2_emblem,String team2,String broadcastingSite){
//        this.competitionName = competitionName;
//        this.daytime = daytime;
//        this.team1 = team1;
//        this.team1_emblem = team1_emblem;
//        this.homeScore = homeScore;
//        this.awayScore = awayScore;
//        this.team2_emblem = team2_emblem;
//        this.team2 = team2;
//        this.broadcastingSite=broadcastingSite;
//    }


}