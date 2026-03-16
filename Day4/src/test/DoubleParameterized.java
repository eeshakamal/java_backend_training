package test;

interface Tests4{
	void add(int a,int b);
}
public class DoubleParameterized {
	public static void main(String[] args) {
		Tests4 i = (a,b) -> System.out.println("Addition: "+ (a+b));
		i.add(3,5);
	}
}