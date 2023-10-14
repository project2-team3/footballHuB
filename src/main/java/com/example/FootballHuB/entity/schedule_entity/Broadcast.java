package com.example.FootballHuB.entity.schedule_entity;

import com.example.FootballHuB.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@ToString
public class Broadcast extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

}
