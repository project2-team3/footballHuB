package com.example.FootballHuB.service.communityService;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import com.example.FootballHuB.entity.communityEntity.CommunityPostComment;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.communityRepository.CommunityPostCommentRepository;
import com.example.FootballHuB.repository.communityRepository.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityPostCommentService {

    @Autowired
    private CommunityPostCommentRepository communityPostCommentRepository;

    @Autowired
    private CommunityPostRepository communityPostRepository;


    @Autowired
    private MemberRepository memberRepository;

    public List<CommunityPost> findByComment(final String communityComment){
        List<CommunityPostComment> communityPostComments = communityPostCommentRepository.findByCommentContentContaining(communityComment);
        List<Long> postNumbers = communityPostComments.stream()
                .map(CommunityPostComment:: getPostNumber)
                .collect(Collectors.toList());
        List<CommunityPost> communityPosts = communityPostRepository.findByIdIn(postNumbers);
        return communityPosts;
    }

}
