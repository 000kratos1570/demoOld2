package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Windows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, material;
    private double width, height;
    private boolean insulation; // изоляция

    public Windows(String name, String material, double width, double height, boolean insulation) {
        this.name = name;
        this.material = material;
        this.width = width;
        this.height = height;
        this.insulation = insulation;
    }

    public Windows() {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isInsulation() {
        return insulation;
    }

    public void setInsulation(boolean insulation) {
        this.insulation = insulation;
    }
}
