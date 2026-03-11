package com.abc;
class Family{
    void property(){
        System.out.println("property");
    }
    void marry(){
        System.out.println("family girl property");

    }
}

public class Overridding extends Family{
    void marry(){
        //super.marry()  to access inside this class
        System.out.println("campus girl property");
    }
    public static void main(String[] args){
        Overridding dd=new Overridding();
        dd.marry();
        dd.property();
    }
}
