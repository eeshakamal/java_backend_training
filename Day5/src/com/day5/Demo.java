package com.day5;

public class Demo extends Thread {
	//Thread class has run method which is executed when we start the thread
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("run method "+i);
		}
	}
	
	public static void main(String[] args) {
		Demo tt = new Demo();
		tt.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Main method "+i);
		}
	}
}
