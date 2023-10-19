package com.example.FootballHuB.entity.gameEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "game_result")
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "gift_id")
    private GameGift gameGift;

    // Getters and setters
}
