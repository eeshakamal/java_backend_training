package test;


interface Tests2 {
	void m1();
}
public class LambdaExpression1{
	void m2()
	{
		System.out.println("Normal mehod");
	}
	public static void main(String[] args) {
		Tests2 t = () -> {
			System.out.println("Lamda expresssion");
		};
		LambdaExpression1 bb = new LambdaExpression1();
		bb.m2();				
		t.m1();
	}

}