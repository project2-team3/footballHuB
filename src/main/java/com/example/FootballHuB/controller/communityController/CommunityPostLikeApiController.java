package com.example.FootballHuB.controller.communityController;

import com.example.FootballHuB.dto.communityDto.postLikeDto.CommunityPostLikeDto;
import com.example.FootballHuB.service.communityService.CommunityPostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like-heart")
public class CommunityPostLikeApiController {
    @Autowired
    private CommunityPostLikeService communityPostLikeService;

    @GetMapping
    public Integer numberOfLikeFind(@RequestParam(value = "q")Long id){
        return communityPostLikeService.numberOfPostLike(id).size();
    }
    @PostMapping("/likey")
    public Long createRemovePostLike (@RequestBody CommunityPostLikeDto heart){
        return communityPostLikeService.createRemove(heart);
    }
}