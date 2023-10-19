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
    private String memberEmail;

    public CommunityPostUpdateRequest() {
    }

    public CommunityPostUpdateRequest(Long id, String title, String content, String memberEmail) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.memberEmail = memberEmail;

    }
}
