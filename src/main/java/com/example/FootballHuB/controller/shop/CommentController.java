package com.example.FootballHuB.controller.shop;

import com.example.FootballHuB.dto.CommentDto;
import com.example.FootballHuB.entity.Comment;
import com.example.FootballHuB.entity.Item;
import com.example.FootballHuB.repository.CommentRepository;
import com.example.FootballHuB.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private final CommentRepository commentRepository;

    @PostMapping(value="/shop/comment")
    public @ResponseBody ResponseEntity comment(@RequestBody @Valid CommentDto commentDto, BindingResult bindingResult, Principal principal) {

        String email = principal.getName();
        CommentDto savedCommentDto;
        try {
            savedCommentDto = commentService.addComment(commentDto, email);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<CommentDto>(savedCommentDto, HttpStatus.OK);
    }

    @GetMapping(value="/shop/comment/{itemId}")
    public @ResponseBody ResponseEntity commentHist(@PathVariable("itemId") Long itemId) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        List<Comment> commentList = commentRepository.findAll();
        for(Comment comment : commentList) {
            commentDtoList.add(CommentDto.of(comment));
        }
        return new ResponseEntity<List<CommentDto>>(commentDtoList, HttpStatus.OK);
    }
}