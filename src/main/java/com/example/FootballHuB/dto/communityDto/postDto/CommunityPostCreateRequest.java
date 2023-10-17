package com.example.FootballHuB.dto.communityDto.postDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommunityPostCreateRequest {

    private String title;
    private String content;
    private Long memberId;

}
