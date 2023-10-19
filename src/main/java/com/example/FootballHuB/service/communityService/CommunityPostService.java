package com.example.FootballHuB.service.communityService;

import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostCreateRequest;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostReadResponse;
import com.example.FootballHuB.dto.communityDto.postDto.CommunityPostUpdateRequest;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import com.example.FootballHuB.repository.MemberRepository;
import com.example.FootballHuB.repository.communityRepository.CommunityPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return communityPostRepository.findAll(Sort.by(Sort.Order.desc("id")))
                .stream()
                .map(CommunityPostReadResponse::fromEntity)
                .collect(Collectors.toList());
    }
    /*public Page<CommunityPostReadResponse> getAll(Pageable pageable) {
        Page<CommunityPost> posts = communityPostRepository.findAll(pageable);
        return posts.map(CommunityPostReadResponse::fromEntity);
    }*/

    public CommunityPostReadResponse getPost(final Long id) {
        return CommunityPostReadResponse.fromEntity(communityPostRepository.getById(id));
    }

    public List<CommunityPost> findByTitle(final String title) {
        return communityPostRepository.findByTitleContaining(title);
    }

    public List<CommunityPost> findByContent(final String content) {
        return communityPostRepository.findByContentContaining(content);
    }

    public List<CommunityPost> findByName(final String name) {
        Member member = memberRepository.findByName(name);
        if (member != null) {
            String memberEmail = member.getEmail();
            return communityPostRepository.findByMemberEmail(memberEmail);
        }
        return Collections.emptyList();
    }

    public Long create(final CommunityPostCreateRequest c) {
        CommunityPost p = new CommunityPost(
                c.getTitle(),
                c.getContent(),
                c.getMemberEmail(),
                c.getDateTime()
        );

        return communityPostRepository.save(p).getId();
    }

    public Long update(final CommunityPostUpdateRequest u) {
        CommunityPost p = communityPostRepository.getReferenceById(u.getId());
        p.setTitle(u.getTitle());
        p.setContent(u.getContent());
        return p.getId();
    }

    public Long delete(final Long postId) {
        String memberEmail = (String) request.getAttribute("eMail");
        CommunityPost p = communityPostRepository.getReferenceById(postId);
        if (p.getMemberEmail() == memberEmail) {
            communityPostRepository.delete(p);
        }
        return p.getId();
    }
}