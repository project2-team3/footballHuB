package com.example.FootballHuB.repository.communityRepository;

import com.example.FootballHuB.entity.communityEntity.CommunityPost;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {

    //public Page<CommunityPost> findAll(Pageable pageable);

    @Override
    CommunityPost getById(Long aLong);

    List<CommunityPost> findByTitleContaining(String s);
    List<CommunityPost> findByContentContaining(String s);
    List<CommunityPost> findByMemberEmail(String s);
    List<CommunityPost> findByIdIn(List<Long> ids);
}
