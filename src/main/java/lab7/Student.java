package lab7;

import java.util.Objects;
import java.time.LocalDate;
import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String faculty;
    private String group;
    private Double rating;
    private String paymentType; // нове поле

    public Student(int id, String name, LocalDate birthDate, String faculty, String group, Double rating, String paymentType) {
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

    @Override
    public String toString() {
        return "Student { " +
                "id= \"" + id + "\"" +
                ", name=\"" + name + "\"" +
                ", birthDate=\"" + birthDate + "\"" +
                ", faculty=\"" + faculty + "\"" +
                ", group=\"" + group + "\"" +
                ", rating=\"" + rating + "\"" +
                ", paymentType=\"" + paymentType + "\"" +
                " };";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(faculty, student.faculty) &&
                Objects.equals(group, student.group) &&
                Objects.equals(rating, student.rating) &&
                Objects.equals(paymentType, student.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, faculty, group, rating, paymentType);
    }
}