package com.example.FootballHuB.dto.communityDto.commentDto;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommunityPostCommentReadResponse {

    private Long id;
    private Long postId;
    private String userName;
    private String commentContent;
    private LocalDateTime dateTime;
    private CommunityPost communityPost;

    public CommunityPostCommentReadResponse() {
    }

    public CommunityPostCommentReadResponse(Long id, Long postId, String userName, String commentContent, LocalDateTime dateTime, CommunityPost communityPost) {
        this.id = id;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
        this.communityPost = communityPost;
    }

    public CommunityPostCommentReadResponse(Long id, Long postId, String userName, String commentContent, LocalDateTime dateTime) {
        this.id = id;
        this.postId = postId;
        this.userName = userName;
        this.commentContent = commentContent;
        this.dateTime = dateTime;
    }
}
