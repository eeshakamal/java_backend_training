package test;

abstract class Animal {
	abstract void eat();
}

public class Demo {

	Animal cc = new Animal() {
		void eat() {
			System.out.println("Animal eat grass");
		}
	};

	public static void main(String[] args) {
		Demo t = new Demo();
		t.cc.eat();
	}

}