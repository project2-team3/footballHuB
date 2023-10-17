package com.example.FootballHuB.dto.communityDto.postDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommunityPostUpdateRequest {

    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private Long likeHeart;
    private Long views;

    public CommunityPostUpdateRequest() {
    }

    public CommunityPostUpdateRequest(Long id, String title, String content, Long memberId, Long likeHeart, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.likeHeart = likeHeart;
        this.views = views;
    }
}
