package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Rating;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
public class RatingDto {
    @NotNull(message = "상품 아이디는 필수 입력 값입니다.")
    private Long orderItemId;

    @NotBlank(message = "평점은 필수 입력 값입니다.")
    private String grade;

    private static ModelMapper modelMapper = new ModelMapper();

    public static RatingDto of(Rating rating){
        return modelMapper.map(rating,RatingDto.class);
    }

}
