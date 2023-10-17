package com.example.FootballHuB.service.communityService;

import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostReadResponse;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.communityRepository.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityPostService {

    @Autowired
    private CommunityPostRepository communityPostRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MemberRepository memberRepository;


    public List<CommunityPostReadResponse> getAll() { // Post내 정보를 모두 불러 오는 함수
        return communityPostRepository.findAll()
                .stream()
                .map(CommunityPostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CommunityPost> findByTitle(final String title){
        return communityPostRepository.findByTitleContaining(title);
    }

    public List<CommunityPost> findByContent(final String content){
        return communityPostRepository.findByContentContaining(content);
    }

    public List<CommunityPost> findByName(final String name){
        Member member= memberRepository.findByName(name);
        if(member != null){
            Long memberId = member.getId();
            return communityPostRepository.findByMemberId(memberId);
        }
        return Collections.emptyList();
    }

    public Long create(final CommunityPostCreateRequest c) {
        CommunityPost p = new CommunityPost(
                c.getTitle(),
                c.getContent(),
                c.getMemberId());

        return communityPostRepository.save(p).getId();
    }

    public Long update(final CommunityPostUpdateRequest u) {
        CommunityPost p = communityPostRepository.getReferenceById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        return p.getId();
    }

    public Long delete(final Long postId) {
        Long memberId = (Long) request.getAttribute("id");
        CommunityPost p = communityPostRepository.getReferenceById(postId);
        if (p.getMemberId() == memberId) {
            communityPostRepository.delete(p);
        }
        return p.getId();
    }
}