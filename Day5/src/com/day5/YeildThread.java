package com.day5;
//yield method is used to pause the execution of the current thread and allow other threads to execute
class YieldMyThread extends Thread {
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			//gives a hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
			Thread.yield();
		}
	}
}
public class YeildThread {
	public static void main(String[] args) {
		YieldMyThread t1 = new YieldMyThread();
		YieldMyThread t2 = new YieldMyThread();

		t1.setName("Thread -1");
		t2.setName("Thread -2");

		t1.start();
		t2.start();
	}
}