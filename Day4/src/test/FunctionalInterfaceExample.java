package test;

@FunctionalInterface
interface MyInterface {
	void m1();
}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {

		MyInterface obj = () -> {
			System.out.println("Hello i am functional interface");
		};
		obj.m1();
	}

}