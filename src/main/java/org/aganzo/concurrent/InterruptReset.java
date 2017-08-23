package org.aganzo.concurrent;

public class InterruptReset {
	public static void main(String[] args) {
		System.out.println("Point A: Thread.interrupted()=" + Thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("Point B: Thread.interrupted()=" + Thread.interrupted());
		System.out.println("Point C: Thread.interrupted()=" + Thread.interrupted());
	}

}
