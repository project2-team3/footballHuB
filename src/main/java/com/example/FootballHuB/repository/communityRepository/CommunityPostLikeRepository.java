package com.example.FootballHuB.repository.communityRepository;

import com.example.FootballHuB.entity.communityEntity.CommunityPostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityPostLikeRepository extends JpaRepository<CommunityPostLike, Long> {

    List<CommunityPostLike> findByPostNumber(long along);
}
