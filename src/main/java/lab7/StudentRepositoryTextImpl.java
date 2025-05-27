package lab7;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryTextImpl implements StudentRepository {
    @Override
    public void outputList(List<Student> students, File file) {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            for (Student s : students) {
                pw.println(s.getId() + ";" + s.getName() + ";" + s.getBirthDate() + ";" + s.getFaculty() + ";" + s.getGroup() + ";" + s.getRating() + ";" + s.getPaymentType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outputList(List<Student> students, String fileName) {
        outputList(students, new File(fileName));
    }

    @Override
    public List<Student> readList(File file) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    LocalDate birthDate = LocalDate.parse(parts[2]);
                    String faculty = parts[3];
                    String group = parts[4];
                    Double rating = Double.parseDouble(parts[5]);
                    String paymentType = parts[6];
                    list.add(new Student(id, name, birthDate, faculty, group, rating, paymentType));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> readList(String fileName) {
        return readList(new File(fileName));
    }
}