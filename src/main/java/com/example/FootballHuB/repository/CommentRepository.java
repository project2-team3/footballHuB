package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.Comment;
import com.example.FootballHuB.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByItemIdOrderByCreatedByDesc(Long itemId);
}
