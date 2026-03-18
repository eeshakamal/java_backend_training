package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    private final Printer printer1;
    private final Printer printer2;
    // Constructor Injection
    public MyRunner(Printer printer1, Printer printer2) {
        this.printer1 = printer1;
        this.printer2 = printer2;
    }
    @Override
    public void run(String... args) throws Exception {
        printer1.printMessage();
        printer2.printMessage();

        // Check both objects are same
        if (printer1 == printer2) {
            System.out.println("Both are SAME object (Singleton)");
        } else {
            System.out.println("Different objects");
        }
    }
}