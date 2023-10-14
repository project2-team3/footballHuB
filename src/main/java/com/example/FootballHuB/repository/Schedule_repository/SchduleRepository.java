package com.example.FootballHuB.repository.Schedule_repository;

import com.example.FootballHuB.entity.schedule_entity.Match;
import com.example.FootballHuB.entity.schedule_entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SchduleRepository extends JpaRepository<Match, Long>{

    @Query("SELECT bp.domain FROM BroadcastProgram bp WHERE bp.match.home = :home AND bp.match.away = :away AND bp.match.datetime = :datetime")
    List<String> finddomain(Team home, Team away, Match datetime);

    @Query("SELECT bp.broadcast.name FROM BroadcastProgram bp WHERE bp.match.home = :home AND bp.match.away = :away AND bp.match.datetime = :datetime")
    List<String> finddbroadcastname(Team home, Team away, Match datetime);

}
