package com.example.FootballHuB.dto.communityDto.postDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CommunityPostCreateRequest {

    private String title;
    private String content;
    private String memberEmail;
    private LocalDateTime dateTime;



}
