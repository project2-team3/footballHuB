package com.shop.service;

import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CategoryInitializer {
    private final CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {
        String[] categories = {"Shoes", "Jerseys", "Apparel", "Soccer Balls", "Goalkeeper", "Uniforms"};
        for (String c : categories) {
            categoryRepository.save(Category.createCategory(c));
        }
    }
}
