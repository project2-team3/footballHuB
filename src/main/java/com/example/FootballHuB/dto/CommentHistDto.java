package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class CommentHistDto {
    private Long itemId;

    private String content;

    private String email;

    private LocalDateTime regTime;

    public CommentHistDto(Long itemId, String content, String email, LocalDateTime regTime) {
        this.itemId = itemId;
        this.content = content;
        this.email = email;
        this.regTime = regTime;
    }
}
