package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class CommentDto {
    @NotNull(message = "상품 아이디는 필수 입력 값입니다.")
    private Long itemId;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    public static CommentDto of(Comment comment){
        return modelMapper.map(comment,CommentDto.class);
    }
}
