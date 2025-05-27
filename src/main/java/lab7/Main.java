package lab7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = fillList();
        StudentController controller = new StudentController(students);
        controller.run();
    }

    private static List<Student> fillList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ivanenko Ivan Ivanovich", LocalDate.of(2003, 12, 13), "CCC", "KN-107", 4.5, "бюджет"));
        students.add(new Student(2, "Mihalenko Mihail Mihailovich", LocalDate.of(2002, 6, 21), "AAA", "KN-205", 4.0, "фiз.особа"));
        students.add(new Student(3, "Antonov Anton Antonovich", LocalDate.of(2003, 5, 5), "AAA", "KN-105", 3.8, "бюджет"));
        students.add(new Student(4, "Tomskiy Tom Tomovich", LocalDate.of(2001, 9, 30), "BBB", "KN-308", 4.2, "юр.особа"));
        students.add(new Student(5, "Dimka Dmitriy Dmitrievich", LocalDate.of(2001, 7, 30), "BBB", "KN-308", 3.9, "фiз.особа"));
        return students;
    }
}