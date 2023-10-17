package com.example.FootballHuB.dto.communityDto.postDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommunityPostReadResponse {

    private Long id;
    private String title;
    private String content;
    private Long memberId;
    private LocalDateTime dataTime;
    private Long likeHeart;
    private Long views;

    public static CommunityPostReadResponse fromEntity(CommunityPost p){
        return new CommunityPostReadResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getMemberId(),
                p.getDateTime(),
                p.getLikeHeart(),
                p.getViews()
        );
    }

    public CommunityPostReadResponse() {
    }

    public CommunityPostReadResponse(Long id, String title, String content, Long memberId, LocalDateTime dataTime, Long likeHeart, Long views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberId = memberId;
        this.dataTime = dataTime;
        this.likeHeart = likeHeart;
        this.views = views;
    }
}
