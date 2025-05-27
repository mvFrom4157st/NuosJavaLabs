package lab7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;


public class StudentService {
        public void printStudentsByFaculty(List<Student> students, String faculty) {
                students.stream()
                        .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                        .forEach(System.out::println);
        }

        public void printStudentsBornAfterYear(List<Student> students, int year) {
                students.stream()
                        .filter(s -> s.getBirthDate().getYear() > year)
                        .forEach(System.out::println);
        }

        public void printStudentsByGroup(List<Student> students, String group) {
                students.stream()
                        .filter(s -> s.getGroup().equalsIgnoreCase(group))
                        .forEach(System.out::println);
        }

        public void printSortedByBirthDateAndName(List<Student> students) {
                students.stream()
                        .sorted(Comparator.comparing(Student::getBirthDate).reversed()
                        .thenComparing(Student::getName))
                        .forEach(System.out::println);
        }

        public void checkAndPrintStudentBirthday(List<Student> students, String name) {
                students.stream()
                        .filter(s -> s.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .ifPresentOrElse(s -> System.out.println("Month: " + s.getBirthDate().getMonthValue()
                                                + ", Day: " + s.getBirthDate().getDayOfMonth()),
                                                () -> System.out.println("Not Found."));
        }

        // 6. List of groups (only фiз.особа) - With streams
        public void printGroupsOnlyFizOsobaWithStreams(List<Student> students) {
                students.stream()
                        .collect(Collectors.groupingBy(Student::getGroup))
                        .entrySet().stream()
                        .filter(e -> e.getValue().stream()
                                        .allMatch(s -> "фiз.особа".equalsIgnoreCase(s.getPaymentType())))
                        .map(Map.Entry::getKey)
                        .forEach(System.out::println);
        }

        // 7. List of groups (only фiз.особа) - Without streams
        public void printGroupsOnlyFizOsobaWithoutStreams(List<Student> students) {
                Set<String> result = new HashSet<>();
                Map<String, List<Student>> map = new HashMap<>();
                for (Student s : students) {
                        map.computeIfAbsent(s.getGroup(), k -> new ArrayList<>()).add(s);
                }
                for (var entry : map.entrySet()) {
                        boolean allFiz = true;
                        for (Student s : entry.getValue()) {
                                if (!"фiз.особа".equalsIgnoreCase(s.getPaymentType())) {
                                        allFiz = false;
                                        break;
                                }
                        }
                        if (allFiz)
                                result.add(entry.getKey());
                }
                for (String group : result)
                        System.out.println(group);
        }

        // 8. Для кожного факультету (key) список його студентів (value) в алфавітному
        // порядку за повним іменем
        public void printFacultyToStudentsMap(List<Student> students) {
                var map = students.stream()
                                .collect(Collectors.groupingBy(
                                                Student::getFaculty,
                                                Collectors.mapping(
                                                                s -> s.getName(),
                                                                Collectors.toCollection(
                                                                                TreeSet::new))));
                map.forEach((faculty, names) -> {
                        System.out.println(faculty + ": " + names);
                });
        }

        // 9. Для кожного року народження (key) кількість студентів (value)
        public void printBirthYearToCountMap(List<Student> students) {
                var map = students.stream()
                                .collect(Collectors.groupingBy( s -> s.getBirthDate().getYear(), Collectors.counting()));
                map.forEach((year, count) -> {
                        System.out.println(year + ": " + count);
                });
        }

        // 10. Search and remove student by name (With streams)
        public boolean removeStudentByNameWithStreams(List<Student> students, String name) {
                var opt = students.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
                if (opt.isPresent()) {
                        students.remove(opt.get());
                        return true;
                }
                return false;
        }

        // 
        public boolean removeStudentByNameWithoutStreams(List<Student> students, String name) {
                for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getName().equalsIgnoreCase(name)) {
                                students.remove(i);
                                return true;
                        }
                }
                return false;
        }

        // 12. Show all students
        public void printAllStudents(List<Student> students) {
                for (Student s : students) {
                        System.out.println(s);
                }
        }
}
