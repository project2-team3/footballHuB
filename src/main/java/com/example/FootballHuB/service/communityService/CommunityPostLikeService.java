package com.example.FootballHuB.service.communityService;

import com.example.FootballHuB.dto.communityDto.postLikeDto.CommunityPostLikeDto;
import com.example.FootballHuB.entity.communityEntity.CommunityPostLike;
import com.example.FootballHuB.repository.communityRepository.CommunityPostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityPostLikeService {
    @Autowired
    private CommunityPostLikeRepository communityPostLikeRepository;

    public List<CommunityPostLike> numberOfPostLike(long id){
        List<CommunityPostLike> postLikes = communityPostLikeRepository.findByPostNumber(id);
        return postLikes;
    }

    public Long createRemove(CommunityPostLikeDto c){
        CommunityPostLike like = new CommunityPostLike(
                c.getPostNumber(),
                c.getMemberNumber(),
                c.getLikeHeart()
        );
        Long memberId = c.getMemberNumber();
        List<Long> postLikes = communityPostLikeRepository.findByPostNumber(c.getPostNumber())
                .stream()
                .map(CommunityPostLike::getMemberNumber)
                .collect(Collectors.toList());
        if(postLikes.contains(memberId)){
            communityPostLikeRepository.delete(like);
        }
        else{
            communityPostLikeRepository.save(like);
        }
        return c.getId();
    }

    public Long create(final CommunityPostLikeDto c){
        CommunityPostLike like = new CommunityPostLike(
                c.getPostNumber(),
                c.getMemberNumber(),
                c.getLikeHeart()
        );
        return communityPostLikeRepository.save(like).getId();
    }

    public Long delete(final CommunityPostLikeDto d){
        CommunityPostLike like = new CommunityPostLike(
                d.getPostNumber(),
                d.getMemberNumber(),
                d.getLikeHeart()
        );
       communityPostLikeRepository.delete(like);
       return d.getId();
    }

}
