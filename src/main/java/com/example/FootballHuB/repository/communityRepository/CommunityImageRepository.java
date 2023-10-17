package com.example.FootballHuB.repository.communityRepository;

import com.example.FootballHuB.entity.communityEntity.CommunityImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityImageRepository extends JpaRepository<CommunityImage, Long> {

    List<CommunityImage> findByPostNumber(Long aLong);

}
