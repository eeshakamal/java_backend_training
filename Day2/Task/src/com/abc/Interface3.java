package com.abc;

public class Interface3 implements it1 {
	public void m2() {
		System.out.println("I m  mehtod m2 ");
	}
	public void m1() {
		System.out.println("I m  mehtod m1 ");
	}
	public void add() {
		System.out.println("addition logic from Interface3");
	}
	public void div() {
		System.out.println("division logic from Interface3");
	}
	public static void main(String[] args) {
		Interface3 ff = new Interface3();
		ff.m1();
		ff.m2();
		ff.add();
		ff.div();
	}
}