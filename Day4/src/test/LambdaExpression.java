package test;

interface Tests1{
	void m1();
}

public class LambdaExpression {
	public static void main(String[] args) {
		Tests1 t = () -> {System.out.println("Method 1");};
		t.m1();
	}
}