package com.abc;
public class Overloading {
    //method overloading
    void m1( ) {
        System.out.println("sdfsdf");
    }
    void m1(int x) {
        System.out.println("sdfsdf"+ x);
    }
    public static void main(String[] args) {
        Overloading oops = new Overloading();
        oops.m1();
        oops.m1(3);

    }
    }
