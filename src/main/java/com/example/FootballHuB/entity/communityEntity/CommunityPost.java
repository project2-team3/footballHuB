package com.example.FootballHuB.entity.communityEntity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

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
    private String memberEmail;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dateTime;


    public CommunityPost() {
    }

    public CommunityPost(Long id, String title, String content, String memberEmail, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberEmail = memberEmail;
        this.dateTime = dateTime;
    }

    public CommunityPost(String title, String content, String memberEmail) {
        this.title = title;
        this.content = content;
        this.memberEmail = memberEmail;
    }

    public CommunityPost(String title, String content, String memberEmail, LocalDateTime dateTime) {
        this.title = title;
        this.content = content;
        this.memberEmail = memberEmail;
        this.dateTime = dateTime;
    }
}
