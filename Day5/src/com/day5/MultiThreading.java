package com.day5;
public class MultiThreading implements Runnable {
//Runnable interface has run method which is executed when we start the thread
	//using class which implements Runnable interface
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("run method" + i);
		}
	}

	public static void main(String[] args) {
		MultiThreading xx = new MultiThreading();
		Thread tt = new Thread(xx);
		tt.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("main method" + i);
		}
	}
}
