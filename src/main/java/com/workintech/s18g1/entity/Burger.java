package com.workintech.s18g1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "burger",schema = "s18g1")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private  String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Column(name = "bread_type")
    private BreadType breadType;

    @Column(name = "contents")
    private String contents;
}
