package com.example.FootballHuB.dto.communityDto.postDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import oracle.jdbc.proxy.annotation.Post;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommunityPostReadResponse {

    private Long id;
    private String title;
    private String content;
    private String memberEmail;
    private LocalDateTime dateTime;

    public static CommunityPostReadResponse fromEntity(CommunityPost p){
        return new CommunityPostReadResponse(
                p.getId(),
                p.getTitle(),
                p.getContent(),
                p.getMemberEmail(),
                p.getDateTime()
        );
    }

    public CommunityPostReadResponse() {
    }

    public CommunityPostReadResponse(Long id, String title, String content, String memberEmail, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberEmail = memberEmail;
        this.dateTime= dateTime;
    }
}
