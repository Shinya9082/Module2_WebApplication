package com.codegym.module2_test.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5,max = 45,message = "Size not match")
    private String name;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @Min(value = 0,message = "Phải là số dương > 0")
    private Long area;

    @Min(value = 0,message = "Phải là số dương > 0")
    private Long population;

    @Min(value = 0,message = "Phải là số dương > 0")
    private Long gdp;

    @Size(min = 25,message = "Nhập thêm giới thiệu")
    private String description;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
