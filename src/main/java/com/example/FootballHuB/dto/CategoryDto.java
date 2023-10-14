package com.shop.dto;

import com.shop.entity.Category;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class CategoryDto {
    private Long id;
    private String name;

    private static ModelMapper modelMapper = new ModelMapper();

    public static CategoryDto of(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
