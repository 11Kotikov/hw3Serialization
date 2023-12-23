package org.homework;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Андрей", 34, 5.0);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student"))) {
            outputStream.writeObject(student);
            System.out.println("Student сериализован");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student"))) {
            Student deserializedStudent = (Student) inputStream.readObject();

            System.out.println("Имя: " + deserializedStudent.getName());
            System.out.println("Возраст: " + deserializedStudent.getAge());
            System.out.println("Средний балл: " + deserializedStudent.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}