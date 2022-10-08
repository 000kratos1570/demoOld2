package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gachi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titlegachi, massagegachi, scream;
    private int countAss, views;

    public Gachi(String titlegachi, String massagegachi, String scream, int countAss, int views) {
        this.titlegachi = titlegachi;
        this.massagegachi = massagegachi;
        this.scream = scream;
        this.countAss = countAss;
        this.views = views;
    }

    public Gachi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlegachi() {
        return titlegachi;
    }

    public void setTitlegachi(String titlegachi) {
        this.titlegachi = titlegachi;
    }

    public String getMassagegachi() {
        return massagegachi;
    }

    public void setMassagegachi(String massagegachi) {
        this.massagegachi = massagegachi;
    }

    public String getScream() {
        return scream;
    }

    public void setScream(String scream) {
        this.scream = scream;
    }

    public int getCountAss() {
        return countAss;
    }

    public void setCountAss(int countAss) {
        this.countAss = countAss;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
