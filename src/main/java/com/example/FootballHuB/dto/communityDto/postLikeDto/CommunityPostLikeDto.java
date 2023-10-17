package com.example.FootballHuB.dto.communityDto.postLikeDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class CommunityPostLikeDto {

    private Long id;
    private Long postNumber;
    private Long memberNumber;
    private Long likeHeart;

    public CommunityPostLikeDto() {
    }

    public CommunityPostLikeDto(Long id, Long postNumber, Long memberNumber, Long likeHeart) {
        this.id = id;
        this.postNumber = postNumber;
        this.memberNumber = memberNumber;
        this.likeHeart = likeHeart;
    }
}
