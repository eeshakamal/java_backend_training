package com.abc;
abstract class Abc
{
	void add()
	{
		System.out.println("additon");
	}
	abstract void div();
}
public class Abstract extends Abc {
	void div()
	{
		System.out.println("division logic");
	}
	public static void main(String[] args) {
		Abstract gg = new Abstract();
		gg.add();
		gg.div();
		}
}
