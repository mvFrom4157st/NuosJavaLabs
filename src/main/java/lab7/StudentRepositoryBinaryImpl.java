package lab7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryBinaryImpl implements StudentRepository {
    @Override
    public void outputList(List<Student> students, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
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
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Student> readList(String fileName) {
        return readList(new File(fileName));
    }
}