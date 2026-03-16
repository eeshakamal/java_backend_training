package com.ab;


import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManager {

  static String[] employeeNames        = new String[100];
  static int[]    employeeAges         = new int[100];
  static String[] employeeDesignations = new String[100];
  static double[] employeeSalaries     = new double[100];
  static int      totalEmployees       = 0;

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean running = true;

    System.out.println("Employee Management App");

    while (running) {
      System.out.println("\n--- Main Menu ---");
      System.out.println("1) Create Employee");
      System.out.println("2) Display Employee");
      System.out.println("3) Raise Salary of Employee");
      System.out.println("4) Exit Application");
      System.out.print("Enter your choice: ");

      int choice;
      try {
        String choiceInput = scanner.nextLine();
        if (!choiceInput.matches("[0-9]+")) {
          throw new IllegalArgumentException("Menu choice must be a number!");
        }
        choice = Integer.parseInt(choiceInput);
        if (choice < 1 || choice > 4) {
          throw new IllegalArgumentException("Invalid menu choice. Please enter a number between 1 and 4.");
        }
      } catch (IllegalArgumentException e) {
        System.out.println("[Error] " + e.getMessage());
        continue;
      }

      switch (choice) {
        case 1:
          createEmployee();
          break;
        case 2:
          displayEmployee();
          break;
        case 3:
          raiseSalary();
          break;
        case 4:
          System.out.println("Exiting Application. Goodbye!");
          running = false;
          break;
      }

      if (running) {
        System.out.print("\nReturn to Main Menu? (Y/N): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (!response.equals("y")) {
          System.out.println("Exiting Application. Goodbye!");
          running = false;
        }
      }
    }
    scanner.close();
  }

  public static void createEmployee() {
    System.out.println("\n--- Create New Employee ---");
    String name = "";
    while (true) {
      System.out.print("Enter employee name (max 2 spaces): ");
      name = scanner.nextLine();

      if (name.trim().isEmpty()) {
        System.out.println("[Error] Name cannot be empty!");
        continue;
      }

      int spaceCount = 0;
      for (int i = 0; i < name.length(); i++) {
        if (name.charAt(i) == ' ') {
          spaceCount++;
        }
      }

      if (spaceCount > 2) {
        System.out.println("[Error] Name can only have up to 2 spaces! You entered " + spaceCount + " spaces.");
      } else {
        break;
      }
    }

    int age = 0;
    while (true) {
      System.out.print("Enter employee age (19-60): ");
      String ageInput = scanner.nextLine();

      // --- Read as String first for robust validation (like Main.java) ---
      if (!ageInput.matches("[0-9]+")) {
        System.out.println("[Error] Age must be a number!");
        continue;
      }

      age = Integer.parseInt(ageInput);

      if (age < 19 || age > 60) {
        System.out.println("[Error] Age must be between 19 and 60! You entered: " + age);
      } else {
        break; // Valid age
      }
    }

    String designation = "";
    double salary      = 0;

    while (true) {
      System.out.println("\n  Available Roles:");
      System.out.println("  -----------------------");
      System.out.println("  Programmer  -> $20,000");
      System.out.println("  Manager     -> $25,000");
      System.out.println("  Tester      -> $15,000");
      System.out.println("  -----------------------");
      System.out.print("Enter Designation (Programmer/Manager/Tester): ");
      designation = scanner.nextLine().trim();

      // --- Empty designation check ---
      if (designation.isEmpty()) {
        System.out.println("[Error] Designation cannot be empty!");
        continue;
      }

      if (designation.equalsIgnoreCase("Programmer")) {
        designation = "Programmer";
        salary      = 20000.00;
        break;
      } else if (designation.equalsIgnoreCase("Manager")) {
        designation = "Manager";
        salary      = 25000.00;
        break;
      } else if (designation.equalsIgnoreCase("Tester")) {
        designation = "Tester";
        salary      = 15000.00;
        break;
      } else {
        System.out.println("[Error] \"" + designation + "\" is not a valid designation!");
        System.out.println("        Valid roles are: Programmer, Manager, Tester");
      }
    }

    System.out.println("\n--- Review Details ---");
    System.out.println("Name        : " + name);
    System.out.println("Age         : " + age);
    System.out.println("Designation : " + designation);
    System.out.println("Salary      : $" + salary);
    System.out.print("Confirm? (y/n): ");

    String confirm = scanner.nextLine().trim().toLowerCase();

    if (confirm.equals("y")) {
      employeeNames[totalEmployees]        = name;
      employeeAges[totalEmployees]         = age;
      employeeDesignations[totalEmployees] = designation;
      employeeSalaries[totalEmployees]     = salary;
      totalEmployees++;
      System.out.println("\nEmployee '" + name + "' created successfully!");
    } else if (confirm.equals("n")) {
      System.out.println("\nEmployee creation cancelled. Going back to main menu...");
    } else {
      System.out.println("\nInvalid input. Going back to main menu...");
    }
  }

  public static void displayEmployee() {

    if (totalEmployees == 0) {
      System.out.println("[Error] No employees found! Please create one first.");
      return;
    }

    System.out.println("\n--- Employee List ---");
    for (int i = 0; i < totalEmployees; i++) {
      System.out.println("\nEmployee #" + (i + 1));
      System.out.println("Name        : " + employeeNames[i]);
      System.out.println("Age         : " + employeeAges[i]);
      System.out.println("Designation : " + employeeDesignations[i]);
      System.out.printf( "Salary      : $%.2f%n", employeeSalaries[i]);
      System.out.println("--------------------");
    }
  }

  public static void raiseSalary() {

    if (totalEmployees == 0) {
      System.out.println("[Error] No employees found! Please create one first.");
      return;
    }

    System.out.println("\n--- Raise Salary ---");
    System.out.println("Select an Employee:");
    System.out.println("--------------------");
    for (int i = 0; i < totalEmployees; i++) {
      System.out.println((i + 1) + ". " + employeeNames[i] +
              " | " + employeeDesignations[i] +
              " | Current Salary: $" + employeeSalaries[i]);
    }
    System.out.println("--------------------");

    int empNumber = 0;
    while (true) {
      System.out.print("Enter Employee Number: ");
      String empInput = scanner.nextLine();

      if (!empInput.matches("[0-9]+")) {
        System.out.println("[Error] Employee number must be a number!");
        continue;
      }

      empNumber = Integer.parseInt(empInput);

      if (empNumber < 1 || empNumber > totalEmployees) {
        System.out.println("[Error] Please enter a number between 1 and " + totalEmployees + "!");
      } else {
        break; // Valid employee number
      }
    }

    int index = empNumber - 1;

    System.out.println("\nEmployee      : " + employeeNames[index]);
    System.out.println("Designation   : " + employeeDesignations[index]);
    System.out.println("Current Salary: $" + employeeSalaries[index]);

    int percentage = 0;
    while (true) {
      System.out.print("Enter salary raise percentage (1-10): ");
      String percentInput = scanner.nextLine();

      if (!percentInput.matches("[0-9]+")) {
        System.out.println("[Error] Percentage must be a number!");
        continue;
      }

      percentage = Integer.parseInt(percentInput);

      if (percentage < 1 || percentage > 10) {
        System.out.println("[Error] Percentage must be between 1 and 10! You entered: " + percentage);
      } else {
        break;
      }
    }

    double oldSalary   = employeeSalaries[index];
    double raiseAmount = oldSalary * percentage / 100;
    double newSalary   = oldSalary + raiseAmount;

    employeeSalaries[index] = newSalary;

    System.out.println("\nSalary updated successfully!");
    System.out.println("--------------------");
    System.out.println("Employee   : " + employeeNames[index]);
    System.out.printf( "Old Salary : $%.2f%n", oldSalary);
    System.out.println("Raise      : " + percentage + "%% = +$" + raiseAmount);
    System.out.printf( "New Salary : $%.2f%n", newSalary);
    System.out.println("--------------------");
  }
}