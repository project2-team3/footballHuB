package com.example.FootballHuB.entity.schedule_entity;

import com.example.FootballHuB.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@ToString
@IdClass(MatchID.class)
public class Match extends BaseEntity {

    @Id
    @ManyToOne
    private Team home;

    @Id
    @ManyToOne
    private Team away;

    @Id
    @Column(nullable = false)
    private Date datetime;

    @Column(name = "home_score")
    private Integer homeScore;

    @Column(name = "away_score")
    private Integer awayScore;

    @Column(name = "competition_name", nullable = false)
    private String competitionName;

    @OneToMany(mappedBy = "match")
    private List<BroadcastProgram> broadcastProgram = new ArrayList<>();

}