
package com.abc;

public class Demo1 {

	void m1() {
		this.m2();
		System.out.println("I am method 1");
		//this.m2();
	}

	void m2() {
		System.out.println("I am method 2");
	}

	public static void main(String[] args) {
		Demo1 gg = new Demo1();
		gg.m1();
		

	}
}
