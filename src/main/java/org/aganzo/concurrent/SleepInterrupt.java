package org.aganzo.concurrent;

public class SleepInterrupt implements Runnable {


	public void run() {

		try {
			System.out.println("in run() - about to sleep for 20 seconds");
			Thread.sleep(20000);
			System.out.println("in run() - woke up");
		} catch (InterruptedException e) {
			System.out.println("in run() - interrupted while sleeping");
			return;
		}
		System.out.println("in run() - leaving normarlly");
	}

	public static void main(String[] args) {

		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("in main() - interrupting other thread");
		t.interrupt();
		System.out.println("in main() - leaving");
	}

}
