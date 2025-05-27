package lab5;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryTextImpl implements StudentRepository {
    @Override
    public void outputArray(Student[] students, File file) {
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Student s : students) {
                pw.println(s.getId() + ";" + s.getName() + ";" + s.getBirthDate() + ";" + s.getFaculty() + ";" + s.getGroup() + ";" + s.getRating());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outputArray(Student[] students, String fileName) {
        outputArray(students, new File(fileName));
    }

    @Override
    public Student[] readArray(File file) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    LocalDate birthDate = LocalDate.parse(parts[2]);
                    String faculty = parts[3];
                    String group = parts[4];
                    Double rating = Double.parseDouble(parts[5]);
                    list.add(new Student(id, name, birthDate, faculty, group, rating));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new Student[0]);
    }

    @Override
    public Student[] readArray(String fileName) {
        return readArray(new File(fileName));
    }
}