package com.abc;
class GrandParent{
    void sugar(){
        System.out.println("this is the method of grand parent class");
    }
}
class Parent1 extends GrandParent{
    void bp(){
        System.out.println("this is the method of parent class");
    }
}
public class Inheritance extends Parent1 {
    void marry(){
        System.out.println("this is the method of child class");
    }

    public static void main(String[] args) {
        Inheritance demo = new Inheritance();
        demo.sugar();
        demo.bp();
        demo.marry();
    }


}
