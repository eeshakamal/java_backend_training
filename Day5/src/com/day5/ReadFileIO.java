package com.day5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileIO {
    public static void main(String[] args) {
        String filePath = "C:/training_ws/Day5/src/com/day5/sample.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading file contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }
}