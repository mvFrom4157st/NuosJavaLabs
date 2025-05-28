package com.nuos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField facultyField;
    @FXML private TextField yearField;
    @FXML private TextField groupField;
    @FXML private TextField studentNameField;
    @FXML private TextArea result;

    private final List<Students> students = Arrays.asList(
        new Students(1, "Ivanenko Ivan Ivanovich", LocalDate.of(2003, 12, 13), "CCC", "KN-107", 4.5, "бюджет"),
        new Students(2, "Mihalenko Mihail Mihailovich", LocalDate.of(2002, 6, 21), "AAA", "KN-205", 4.0, "фіз.особа"),
        new Students(3, "Antonov Anton Antonovich", LocalDate.of(2003, 5, 5), "AAA", "KN-105", 3.8, "бюджет"),
        new Students(4, "Tomskiy Tom Tomovich", LocalDate.of(2001, 9, 30), "BBB", "KN-308", 4.2, "юр.особа"),
        new Students(5, "Dimka Dmitriy Dmitrievich", LocalDate.of(2001, 7, 30), "BBB", "KN-308", 3.9, "фіз.особа")
    );

    @FXML
    private void showByFaculty() {
        String faculty = facultyField.getText().trim();
        List<Students> filtered = students.stream()
                .filter(s -> s.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
        result.setText("Студенти факультету " + faculty + ":\n" + toStringList(filtered));
    }

    @FXML
    private void showBornAfterYear() {
        try {
            int year = Integer.parseInt(yearField.getText().trim());
            List<Students> filtered = students.stream()
                    .filter(s -> s.getBirthDate().getYear() > year)
                    .collect(Collectors.toList());
            result.setText("Студенти, народжені після " + year + ":\n" + toStringList(filtered));
        } catch (NumberFormatException e) {
            result.setText("Введіть коректний рік.");
        }
    }

    @FXML
    private void showByGroup() {
        String group = groupField.getText().trim();
        List<Students> filtered = students.stream()
                .filter(s -> s.getGroup().equalsIgnoreCase(group))
                .collect(Collectors.toList());
        result.setText("Студенти групи " + group + ":\n" + toStringList(filtered));
    }

    @FXML
    private void sortByBirthDesc() {
        List<Students> sorted = students.stream()
                .sorted(Comparator.comparing(Students::getBirthDate).reversed()
                        .thenComparing(Students::getName))
                .collect(Collectors.toList());
        result.setText("Список за спаданням дати народження:\n" + toStringList(sorted));
    }

    @FXML
    private void checkStudent() {
        String name = studentNameField.getText().trim();
        Optional<Students> found = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
        if (found.isPresent()) {
            MonthDay md = MonthDay.from(found.get().getBirthDate());
            result.setText("Студент знайдений!\nМісяць: " + md.getMonthValue() + ", День: " + md.getDayOfMonth());
        } else {
            result.setText("Студента не знайдено.");
        }
    }

    @FXML
    private void showGroupsOnlyPhysical() {
        Set<String> groups = students.stream()
                .collect(Collectors.groupingBy(Students::getGroup))
                .entrySet().stream()
                .filter(e -> e.getValue().stream().allMatch(s -> s.getPaymentType().equalsIgnoreCase("фіз.особа")))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        result.setText("Групи лише фіз. особи:\n" + String.join(", ", groups));
    }

    @FXML
    private void mapFacultyToStudents() {
        Map<String, List<Students>> map = students.stream()
                .collect(Collectors.groupingBy(Students::getFaculty));
        StringBuilder sb = new StringBuilder();
        map.forEach((faculty, list) -> {
            sb.append(faculty).append(":\n");
            list.stream()
                .sorted(Comparator.comparing(Students::getName))
                .forEach(s -> sb.append("  ").append(s.getName()).append("\n"));
        });
        result.setText("Факультет + студенти:\n" + sb);
    }

    @FXML
    private void mapYearToCount() {
        Map<Integer, Long> map = students.stream()
                .collect(Collectors.groupingBy(s -> s.getBirthDate().getYear(), Collectors.counting()));
        StringBuilder sb = new StringBuilder();
        map.forEach((year, count) -> sb.append(year).append(": ").append(count).append("\n"));
        result.setText("Pік + Кількість студентів:\n" + sb);
    }

    private String toStringList(List<Students> list) {
        if (list.isEmpty()) return "Нічого не знайдено.";
        return list.stream()
                .map(s -> s.getName() + " (" + s.getGroup() + ", " + s.getBirthDate() + ")")
                .collect(Collectors.joining("\n"));
    }
}
