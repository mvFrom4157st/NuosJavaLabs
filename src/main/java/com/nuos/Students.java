package com.nuos;

import java.time.LocalDate;

public class Students {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String faculty;
    private String group;
    private Double rating;
    private String paymentType;

    public Students(int id, String name, LocalDate birthDate, String faculty, String group, Double rating, String paymentType) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.group = group;
        this.rating = rating;
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
