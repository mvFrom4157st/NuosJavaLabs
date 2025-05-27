package lab5;

import java.io.*;

public class StudentRepositoryBinaryImpl implements StudentRepository {
    @Override
    public void outputArray(Student[] students, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(students);
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
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Student[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Student[0];
    }

    @Override
    public Student[] readArray(String fileName) {
        return readArray(new File(fileName));
    }
}