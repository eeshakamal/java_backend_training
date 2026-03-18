package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component   // Spring will create ONLY ONE object
@Scope("singleton") 
public class Printer {
    public Printer() {
        System.out.println("Printer Object Created");
    }
    public void printMessage() {
        System.out.println("Printing Document...");
    }
}
