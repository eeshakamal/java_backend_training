package com.day5;
// Renamed YieldMyThread to PriorityMyThread to avoid duplicate class definition error
class PriorityMyThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() +
				" --Is running with --" + Thread.currentThread().getPriority());
	}
}

public class PriorityThread {
	public static void main(String[] args) {
		PriorityMyThread t1 = new PriorityMyThread();
		PriorityMyThread t2 = new PriorityMyThread();
		PriorityMyThread t3 = new PriorityMyThread();

		t1.setName("Low Priority");
		t2.setName("Normal Priority");
		t3.setName("High Priority");

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
	}
}