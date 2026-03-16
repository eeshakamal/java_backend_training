package com.day5;
class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("run method " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class Isalive {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		//isAlive method is used to check whether the thread is alive or not
		System.out.println(" Before thread is alive"+t1.isAlive());
		t1.start();
		System.out.println(" After thread is alive"+t1.isAlive());
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" After finsihing "+t1.isAlive());
		
	}
}