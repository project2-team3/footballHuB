package com.example.FootballHuB.entity.communityEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class CommunityPostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long memberNumber;

    @Column(nullable = false)
    private Long postNumber;

    @Column(nullable = false)
    private Long likeHeart;

    public CommunityPostLike() {
    }

    public CommunityPostLike(Long id, Long memberNumber, Long postNumber, Long likeHeart) {
        this.id = id;
        this.memberNumber = memberNumber;
        this.postNumber = postNumber;
        this.likeHeart = likeHeart;
    }

    public CommunityPostLike(Long memberNumber, Long postNumber, Long likeHeart) {
        this.memberNumber = memberNumber;
        this.postNumber = postNumber;
        this.likeHeart = likeHeart;
    }
}
