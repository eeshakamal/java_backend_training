package com.day5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaIO  {

    public static void main(String[] args) {

        String filePath = "C:/training_ws/Day5/src/com/day5/sample.txt";
        // Step 1: Write to file
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write("Eesha.");
            fw.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e);
        }

        try {
            // Step 1: Create FileReader object
            FileReader fr = new FileReader(filePath);
            int i;   
            System.out.println("Reading data from file:");
            // Step 2: Read character by character
            while((i = fr.read()) != -1) {
                System.out.print((char)i);
            }
            // Step 3: Close the file
            fr.close();
        }
        catch(IOException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}