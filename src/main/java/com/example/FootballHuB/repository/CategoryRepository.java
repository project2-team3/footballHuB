package com.example.FootballHuB.repository;

import com.example.FootballHuB.entity.Category;
import com.example.FootballHuB.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
    Category findByName(String name);

}
