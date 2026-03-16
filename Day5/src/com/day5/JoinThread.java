package com.day5;

//join method is used to wait for a thread to die 
class Boilwater extends Thread {
	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println("water is boiling... step " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("water boilging finished");
	}
}
//It means that the current thread will wait until the thread on which join() is called has finished its execution.
public class JoinThread {
	public static void main(String[] args) {
		Boilwater t1 = new Boilwater();
		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Now add tea powder");
	}
}

