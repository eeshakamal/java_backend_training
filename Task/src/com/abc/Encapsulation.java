package com.abc;

class EncapsulatedAbc {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}

public class Encapsulation extends EncapsulatedAbc {

	public static void main(String[] args) {
		Encapsulation gg = new Encapsulation();
		gg.setA(22);
		int ab = gg.getA();
		System.out.println(ab);
	}
}