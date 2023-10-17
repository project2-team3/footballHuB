package com.example.FootballHuB.service;

import com.example.FootballHuB.dto.CategoryDto;
import com.example.FootballHuB.entity.Category;
import com.example.FootballHuB.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategory() {
        var categoryList = categoryRepository.findAll();
//        var categoryDtoList = new ArrayList<CategoryDto>();

//        for (Category category : categoryList) {
//            CategoryDto categoryDto = CategoryDto.of(category);
//            categoryDtoList.add(categoryDto);
//        }
//        return categoryDtoList;

        return categoryList.stream()
                .map(CategoryDto::of)
                .toList();
    }
}
