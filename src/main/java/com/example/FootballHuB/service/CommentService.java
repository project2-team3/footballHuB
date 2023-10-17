package com.example.FootballHuB.service;

import com.example.FootballHuB.dto.CommentDto;
import com.example.FootballHuB.dto.CommentHistDto;
import com.example.FootballHuB.entity.Comment;
import com.example.FootballHuB.entity.Item;
import com.example.FootballHuB.entity.Member;
import com.example.FootballHuB.repository.CommentRepository;
import com.example.FootballHuB.repository.ItemRepository;
import com.example.FootballHuB.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final ItemRepository itemRepository;

    private final CommentRepository commentRepository;

    private final MemberRepository memberRepository;

    public CommentHistDto addComment(CommentDto commentDto, String email) {
        Item item = itemRepository.findById(commentDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setMember(member);
        comment.setItem(item);

        commentRepository.save(comment);

        return new CommentHistDto(comment.getId(), comment.getContent(), email, comment.getRegTime());
    }
}
