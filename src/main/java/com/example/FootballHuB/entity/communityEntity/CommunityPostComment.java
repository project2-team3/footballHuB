package com.example.FootballHuB.entity.communityEntity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
public class CommunityPostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postNumber;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private CommunityPost communityPost;


    public CommunityPostComment() {
    }

    public CommunityPostComment(Long id, Long postNumber, String userName, String commentContent, LocalDateTime dateTime, CommunityPost communityPost) {
        this.id = id;
        this.postNumber = postNumber;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
        this.communityPost = communityPost;
    }
}
