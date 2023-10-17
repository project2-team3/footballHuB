package com.example.FootballHuB.entity.gameEntity;

import com.example.FootballHuB.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_content")
    private String gameContent;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "result_id", insertable = false, updatable = false)
    private GameResult gameResult;

    // Getters and setters
}
