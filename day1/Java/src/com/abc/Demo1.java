package com.abc;

public class Demo1 {
    int a=19;
    static	int b =20;

    void m1() {
        int a =29;
        System.out.println("this is the method"+a);
    }

    public Demo1() {
        int a = 10;
        System.out.println("constrctor"+a);
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.m1();
        System.out.println(demo.a);
        System.out.println(b);

    }
}
