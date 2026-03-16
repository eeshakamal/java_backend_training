package com.day5;

import java.io.Serializable;

class Student implements Serializable {
    public int id;
    public String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class ByteStream {
    public static void main(String[] args) {
        try {
            Student s = new Student(101, "Eesha");
            java.io.FileOutputStream fos = new java.io.FileOutputStream("C:/training_ws/Day5/src/com/day5/student.txt");
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
            System.out.println("Object serialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            java.io.FileInputStream fis = new java.io.FileInputStream("C:/training_ws/Day5/src/com/day5/student.txt");
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis);
            Student s2 = (Student) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Object deserialized successfully.");
            System.out.println("student id:" + s2.id + " and name " + s2.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}