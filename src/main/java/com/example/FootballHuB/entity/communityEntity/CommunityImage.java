package com.example.FootballHuB.entity.communityEntity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class CommunityImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long postNumber;
    @Column(nullable = false)
    private Long memberNumber;
    @Column(nullable = false)
    private String imageName;
    @Column(nullable = false)
    private String imageSrc;

    public CommunityImage() {
    }

    public CommunityImage(Long postNumber, Long memberNumber, String imageName, String imageSrc) {
        this.postNumber = postNumber;
        this.memberNumber = memberNumber;
        this.imageName = imageName;
        this.imageSrc = imageSrc;
    }

}