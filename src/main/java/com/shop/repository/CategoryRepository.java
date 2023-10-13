package com.shop.repository;

import com.shop.entity.Category;
import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
    Category findByName(String name);

}
