package com.example.FootballHuB.repository.communityRepository;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    List<CommunityPost> findByTitleContaining(String s);
    List<CommunityPost> findByContentContaining(String s);
    List<CommunityPost> findByMemberId(Long along );
    List<CommunityPost> findByLikeHeart(Long aLong);
    List<CommunityPost> findByIdIn(List<Long> ids);
}
