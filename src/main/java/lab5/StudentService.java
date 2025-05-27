package lab5;

import java.util.Arrays;

public class StudentService {
    public void printAllStudents(Student[] students) {
        Arrays.stream(students).forEach(System.out::println);
    }

    public void printStudentsByGroup(Student[] students, String group) {
        Arrays.stream(students)
                .filter(s -> s.getGroup().equals(group))
                .forEach(System.out::println);
    }

    public void printStudentsByFaculty(Student[] students, String faculty) {
        Arrays.stream(students)
                .filter(s -> s.getFaculty().equals(faculty))
                .forEach(System.out::println);
    }

    public void printStudentsByYear(Student[] students, int yearLimit) {
        Arrays.stream(students)
                .filter(s -> s.getBirthDate().getYear() > yearLimit)
                .forEach(System.out::println);
    }
}
