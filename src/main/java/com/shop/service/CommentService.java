package com.shop.service;

import com.shop.dto.CommentDto;
import com.shop.entity.Comment;
import com.shop.entity.Item;
import com.shop.entity.Member;
import com.shop.repository.CommentRepository;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
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

    public CommentDto addComment(CommentDto commentDto, String email) {
        Item item = itemRepository.findById(commentDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setMember(member);
        comment.setItem(item);

        commentRepository.save(comment);
        return CommentDto.of(comment);
    }
}
