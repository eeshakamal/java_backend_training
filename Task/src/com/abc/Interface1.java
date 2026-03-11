package com.abc;

public class Interface1 extends Abc {
	public void div() {
		System.out.println("divison logic");
	}
	public void add() {
		System.out.println("addition logic from Interface1");
	}
	public static void main(String[] args) {
		Interface1 gg = new Interface1();
		gg.add();
		gg.div();
	}
}