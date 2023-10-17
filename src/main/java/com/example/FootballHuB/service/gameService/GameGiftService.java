package com.example.FootballHuB.service.gameService;

import com.example.FootballHuB.entity.gameEntity.GameGift;
import com.example.FootballHuB.repository.gameRepository.GameGiftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GameGiftService {

    private final GameGiftRepository gameGiftRepository;
    private static final Logger logger = LoggerFactory.getLogger(GameGiftService.class);

    @Autowired
    public GameGiftService(GameGiftRepository gameGiftRepository) {
        this.gameGiftRepository = gameGiftRepository;
    }


    // 모든 GameGift 조회
    public List<GameGift> getAllGameGifts() {
        logger.debug("Fetching all game gifts from the database.");
        List<GameGift> gameGifts = gameGiftRepository.findAll();
        logger.debug("Fetched {} game gifts from the database.", gameGifts.size());
        return gameGifts;
    }

    // 특정 ID의 GameGift 조회
    public GameGift getGameGiftById(Long giftId) {
        return gameGiftRepository.findById(giftId)
                .orElseThrow(() -> new EntityNotFoundException("GameGift not found with ID: " + giftId));
    }

    // GameGift 생성
    public GameGift createGameGift(GameGift gameGift) {
        return gameGiftRepository.save(gameGift);
    }

    // GameGift 수정
    public GameGift updateGameGift(Long giftId, GameGift gameGift) {
        if (!gameGiftRepository.existsById(giftId)) {
            throw new EntityNotFoundException("GameGift not found with ID: " + giftId);
        }
        gameGift.setGiftId(giftId);
        return gameGiftRepository.save(gameGift);
    }

    // GameGift 삭제
    public void deleteGameGift(Long giftId) {
        if (!gameGiftRepository.existsById(giftId)) {
            throw new EntityNotFoundException("GameGift not found with ID: " + giftId);
        }
        gameGiftRepository.deleteById(giftId);
    }
}
