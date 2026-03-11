package com.abc;
public class MathOperations {
    void add() {
        System.out.println("addition " + (3 + 4));
    }

    void mul() {
        System.out.println("multiplication " + (3 * 4));
    }

    void div() {
        System.out.println("division " + (3 / 1));
    }

    void sub() {
        System.out.println("subtraction " + (5 - 2));
    }
    
    void fibanacci(int n) {
		int a = 0, b = 1;
		System.out.print("Fibonacci series: ");
		for (int i = 0; i < n; i++) {
			System.out.print(a + " ");
			int next = a + b;
			a = b;
			b = next;
		}
		System.out.println();
    }
    
     void factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		System.out.println("Factorial of " + n + " is: " + fact);
     }
		
    void areaOfCircle(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of circle: " + area);
    }

    void areaOfTriangle(double base, double height) {
        double area = 0.5 * base * height;
        System.out.println("Area of triangle: " + area);
    }

    public static void main(String[] args) {
        MathOperations math = new MathOperations();
        math.add();
        math.mul();
        math.div();
        math.sub();
        math.areaOfCircle(5);
        math.areaOfTriangle(4, 3);
        math.fibanacci(10);
        math.factorial(5);
    }
}
