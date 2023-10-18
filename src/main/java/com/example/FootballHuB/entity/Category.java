package com.example.FootballHuB.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter @Setter
@RequiredArgsConstructor
public class Category extends BaseTimeEntity {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public static Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
