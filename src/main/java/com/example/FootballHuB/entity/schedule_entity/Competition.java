package com.example.FootballHuB.entity.schedule_entity;

import com.example.FootballHuB.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString
public class Competition extends BaseEntity {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

}

