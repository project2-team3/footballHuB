package com.example.FootballHuB.entity.schedule_entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class BroadcastProgramID implements Serializable {

    @ManyToOne
    private Match match;

    @ManyToOne
    private Broadcast broadcast;

}
