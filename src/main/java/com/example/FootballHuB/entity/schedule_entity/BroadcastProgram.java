package com.example.FootballHuB.entity.schedule_entity;

import com.example.FootballHuB.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@ToString
@IdClass(BroadcastProgramID.class)
public class BroadcastProgram extends BaseEntity {

    @Id
    @ManyToOne
    private Match match;

    @Id
    @ManyToOne
    private Broadcast broadcast;

    @Column(name = "domain", nullable = false)
    private String domain;

}
