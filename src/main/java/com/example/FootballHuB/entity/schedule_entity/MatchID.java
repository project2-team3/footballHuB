package com.example.FootballHuB.entity.schedule_entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class MatchID implements Serializable {

    @ManyToOne
    private Team home;

    @ManyToOne
    private Team away;

    @Column(nullable = false)
    private Date datetime;

}
