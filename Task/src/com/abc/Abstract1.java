package com.abc;
abstract class Abstract1Base
{
	abstract void add();
	abstract void div();
}
abstract class Abcd extends Abstract1Base
{
	void add()
	{
		System.out.println("addtion logic");
	}
}
public class Abstract1 extends Abcd {
	void div()
	{
		System.out.println("Division logic");
	}
	public static void main(String[] args) {
		Abstract1 gg = new Abstract1();
		gg.add();
		gg.div();
		}
}