package org.aganzo.concurrent;

public class PendingInterrupt {

	public static void main(String[] args) {
		Thread.currentThread().interrupt();
		long startTime = System.currentTimeMillis();
		System.out.println("start time: " + startTime);
		try {
			Thread.sleep(2000);
			System.out.println("was NOT interrupted");
		} catch (InterruptedException e) {
			System.out.println("was interrupted");
		}
		System.out.println("elapsed time:" + (System.currentTimeMillis() - startTime));
	}

}
