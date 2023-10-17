package com.example.FootballHuB.dto.communityDto.commentDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString

public class CommunityPostCommentCreateRequest {

    private Long id;
    private Long postId;
    private String UserName;
    private String commentContent;
    private LocalDateTime dateTime;
    private CommunityPost communityPost;

    public CommunityPostCommentCreateRequest() {
    }

    public CommunityPostCommentCreateRequest(Long id, Long postId, String userName, String commentContent, LocalDateTime dateTime, CommunityPost communityPost) {
        this.id = id;
        this.postId = postId;
        UserName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
        this.communityPost = communityPost;
    }
}
