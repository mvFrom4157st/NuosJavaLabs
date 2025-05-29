package com.nuos;

import java.util.Objects;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String faculty;
    private String group;

    public Student(int id, String name, LocalDate birthDate, String faculty, String group) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.faculty = faculty;
        this.group = group;
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

    @Override
    public String toString() {
        return "Student { " +
                "id= " + "\"" + id + "\"" +
                ", name=" + "\"" + name + "\"" + 
                ", birthDate=" + "\"" + birthDate + "\"" +
                ", faculty=" + "\"" + faculty + "\"" +
                ", group=" + "\"" + group + "\"" +
                " };";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                faculty == student.faculty &&
                group == student.group &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthDate, student.birthDate);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, faculty, group);
    }
}