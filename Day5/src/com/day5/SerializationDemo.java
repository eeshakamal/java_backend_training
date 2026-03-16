package com.day5;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Student implements Serializable {
    public String name;
    public int age;
    public double salary;
    public String designation;
    public Student(String name, int age, double salary, String designation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        try {
            // object serialization: converting an object's state into a byte stream
            Student s = new Student("Eesha", 25, 55000.0, "Developer");
            FileOutputStream fos = new FileOutputStream("C:/training_ws/Day5/src/com/day5/student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
            System.out.println("Object serialized successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // byte stream: sequence of bytes for binary data
            FileInputStream fis = new FileInputStream("C:/training_ws/Day5/src/com/day5/student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student s2 = (Student) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Object deserialized successfully.");
            System.out.println("Name: " + s2.name);
            System.out.println("Age: " + s2.age);
            System.out.println("Salary: " + s2.salary);
            System.out.println("Designation: " + s2.designation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}