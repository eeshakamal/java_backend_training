package com.day5;

class Trafficsignal extends Thread {
	public void run() {
		try {
			System.out.println("Red Light - Stop");
			//sleep method is used to pause the execution of the thread for a specified time in milliseconds
			Thread.sleep(3000);
			System.out.println("Yellow Light - Ready");
			Thread.sleep(1000);
			System.out.println("Green light - Go");
		} catch (InterruptedException e) {
			System.out.println("I am getting an error" + e);
		}

	}
}
public class SleepMethod {
public static void main(String[] args) {
	
	Trafficsignal  ff = new Trafficsignal();
	ff.start();
}
}

