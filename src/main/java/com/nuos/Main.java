package com.nuos;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        Student[] students = fillArray();
        System.out.println("---------------------");
        System.out.println("All students:");
        printAllStudents(students);
        System.out.println("---------------------");
        System.out.println("1. Enter group for a filter: ");
        String groupFilter = scanner.nextLine();
        System.out.println("All students from:" + " " + groupFilter + " " + "group:");
        printStudentsByGroup(students, groupFilter);
        System.out.println("---------------------");
        System.out.println("2. Enter faculty for a filter: ");
        String facultyFilter = scanner.nextLine();
        System.out.println("All students from:" + " " + facultyFilter + " " + "faculty:");
        printStudentsByFaculty(students, facultyFilter);
        System.out.println("---------------------");
        System.out.println("3. Enter year for a filter: ");
        Integer yearFilter = scanner.nextInt();
        System.out.println("All students who borth after " +  yearFilter);
        printStudentsByYear(students, yearFilter);
        System.out.println("---------------------");
    }

    private void printStudentsByYear(Student[] students, Integer yearLimit) {
        for (Student student : students) {
            if (student.getBirthDate().getYear() > yearLimit) {
                System.out.println(student);
            }
        }
    }

    private void printStudentsByGroup(Student[] students, String group) {
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                System.out.println(student);
            }
        }
    }

    private void printStudentsByFaculty(Student[] students, String faculty) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
    }

    private void printAllStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Student[] fillArray() {
        return new Student[]{
                new Student(1, "Ivanenko Ivan Ivanovich", LocalDate.of(2003, 12, 13), "CCC", "KN-107"),
                new Student(2, "Mihalenko Mihail Mihailovich", LocalDate.of(2002, 6, 21), "AAA", "KN-205"),
                new Student(3, "Antonov Anton Antonovich", LocalDate.of(2003, 5, 5), "AAA", "KN-105"),
                new Student(4, "Tomskiy Tom Tomovich", LocalDate.of(2001, 9, 30), "BBB", "KN-308"),
                new Student(5, "Dimka Dmitriy Dmitrievich", LocalDate.of(2001, 7, 30), "BBB", "KN-308")
        };
    }
}