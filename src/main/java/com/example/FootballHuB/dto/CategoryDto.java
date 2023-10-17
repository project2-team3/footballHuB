package com.example.FootballHuB.dto;

import com.example.FootballHuB.entity.Category;
import com.example.FootballHuB.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class CategoryDto {
    private Long id;
    private String name;

    private static ModelMapper modelMapper = new ModelMapper();

    public Category createCategory() {
        return modelMapper.map(this, Category.class);
    }

    public static CategoryDto of(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
