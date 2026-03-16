package test;
interface Tests3 {
	int m1(int x);
}


public class LambdaSingleParameterized {
	public static void main(String[] args) {
		Tests3 i = x -> x * x;
		System.out.println("the square " + i.m1(5));
	}
}
