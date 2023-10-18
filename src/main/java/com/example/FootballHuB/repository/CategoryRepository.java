package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
    Category findByName(String name);

}
