package test;

//anonymous inner class is used to access the methods inside the abstract class and interface.

interface Tests 
{
public abstract	void m1();
}
class OuterClass
{
	void m2()
	{
		System.out.println("M2 method");
	}
	Tests t = new Tests() { // t is the anonymous inner class.
		public void m1() {
           System.out.println("Hello world");			
		}
	};
}

public class Demo1 {

	 public static void main(String[] args) {
		 OuterClass cc = new OuterClass();
		 cc.m2();
		 cc.t.m1();
	}
	
}


