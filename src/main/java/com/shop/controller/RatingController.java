package com.shop.controller;

import com.shop.dto.CommentDto;
import com.shop.dto.RatingDto;
import com.shop.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @PostMapping(value="/rating")
    public @ResponseBody ResponseEntity addRating(@RequestBody @Valid RatingDto ratingDto, BindingResult bindingResult, Principal principal) {

//        if(bindingResult.hasErrors()) {
//            StringBuilder sb = new StringBuilder();
//            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//            for(FieldError fieldError : fieldErrors) {
//                sb.append(fieldError.getDefaultMessage());
//            }
//            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
//        }

        String email = principal.getName();
        Long ratingId;

        try {
            ratingId = ratingService.addRating(ratingDto, email);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(ratingId, HttpStatus.OK);
    }

//    @GetMapping(value="/comment/{itemId}")
//    public @ResponseBody ResponseEntity commentHist(@PathVariable("itemId") Long itemId) {
//        List<CommentDto> commentDtoList = new ArrayList<>();
//        List<Comment> commentList = commentRepository.findAll();
//        for(Comment comment : commentList) {
//            commentDtoList.add(CommentDto.of(comment));
//        }
//        return new ResponseEntity<List<CommentDto>>(commentDtoList, HttpStatus.OK);
//    }
}
