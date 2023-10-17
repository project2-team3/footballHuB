package com.example.FootballHuB.controller.communityController;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import com.example.FootballHuB.service.communityService.CommunityPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CommunityCommentApiController {

    @Autowired
    private CommunityPostCommentService communityPostCommentService;


    @GetMapping("/comment")
    public List<CommunityPost> findByComment(@RequestParam(value = "q")final String comment){
        return communityPostCommentService.findByComment(comment);
    }

}
