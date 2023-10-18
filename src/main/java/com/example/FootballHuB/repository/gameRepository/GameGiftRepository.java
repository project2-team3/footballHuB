package com.example.FootballHuB.repository.gameRepository;

import com.example.FootballHuB.entity.gameEntity.GameGift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameGiftRepository extends JpaRepository<GameGift, Long> {
    // 추가적인 쿼리 메소드가 필요하다면 여기에 선언할 수 있습니다.
}

