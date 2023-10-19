package com.example.FootballHuB.entity.gameEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@ToString
@Setter
@Entity
@Table(name = "game_gift")
public class GameGift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gift_id")
    private Long giftId;

    @Column(name = "gift_name")
    private String giftName;

    @Column(name = "gift_content")
    private String giftContent;

    @Column(name = "gift_image")
    private String giftImage;

    // Getters and setters


}

