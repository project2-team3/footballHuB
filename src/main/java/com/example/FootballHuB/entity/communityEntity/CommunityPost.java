package com.example.FootballHuB.entity.communityEntity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class CommunityPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Long likeHeart;

    @Column(nullable = false)
    private Long views;

    public CommunityPost() {
    }

    public CommunityPost(String title, String content, Long memberId ) {
        this.title = title;
        this.content = content;
        this.memberId = memberId;

    }

    public CommunityPost(Long id, String title, String content, Long memberId, LocalDateTime dateTime, Long likeHeart, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.dateTime = dateTime;
        this.likeHeart = likeHeart;
        this.views = views;
    }
}
