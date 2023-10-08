package com.shop.service;

import com.shop.dto.CategoryDto;
import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
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
    public List<CategoryDto> getAllCategory(){
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDto categoryDto = CategoryDto.of(category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
