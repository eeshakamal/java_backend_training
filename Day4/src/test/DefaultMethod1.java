package test;

interface Left {
	default void m1() {
		System.out.println("Left defualt method");
	}
	static void m2() {
		System.out.println("Left defualt method 2");
	}
}
interface Right {
	default void m1() {
		System.out.println("Righ defualt method");
	}
}
public class DefaultMethod1 implements Left, Right {
	public void m1() {
//		Left.super.m1();
//		System.out.println("My m1 method");
		Left.m2(); // accessing without super keyword
	}
	public static void main(String[] args) {
		DefaultMethod1 t = new  DefaultMethod1();
		t.m1();
	}
}
