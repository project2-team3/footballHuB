package com.example.FootballHuB.controller.communityController;

import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostReadResponse;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import com.example.FootballHuB.service.communityService.CommunityPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gall")
public class CommunityPostApiController {

    @Autowired
    private CommunityPostService communityPostService;

    public UserDetails getCurrentUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/post")
    public List<CommunityPostReadResponse> AllPost() {
        return communityPostService.getAll();
    }

    @GetMapping("/{id}")
    public CommunityPostReadResponse readPost(@PathVariable(value = "id") Long id) {
        return communityPostService.getPost(id);
    }

    @GetMapping("/title-page")
    public List<CommunityPost> findByTitle(@RequestParam(value = "q") final String title) {
        return communityPostService.findByTitle(title);
    }

    @GetMapping("/content-page")
    public List<CommunityPost> findByContent(@RequestParam(value = "q") final String content) {
        return communityPostService.findByContent(content);
    }

    @GetMapping("/member-page")
    public List<CommunityPost> findByName(@RequestParam(value = "q") final String name) {
        return communityPostService.findByName(name);
    }

    @PostMapping("/write")
    public Long createPost(@RequestBody CommunityPostCreateRequest c) {
        return communityPostService.create(c);
    }

    @GetMapping("/user")
    public UserDetails getCurrentUser() {
        return getCurrentUserDetails();
    }

    @PutMapping("/update")
    public Long updatePost(@RequestBody CommunityPostUpdateRequest u) {
        return communityPostService.update(u);
    }

    @DeleteMapping("/{postId}")
    public Long deletePost(@PathVariable(value = "postId") Long postId) {
        return communityPostService.delete(postId);
    }

}