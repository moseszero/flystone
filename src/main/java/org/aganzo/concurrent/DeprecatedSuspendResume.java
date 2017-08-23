package org.aganzo.concurrent;

public class DeprecatedSuspendResume implements Runnable {
	private volatile int firstValue;
	private volatile int secondeValue;
	
	public boolean areValuesEqual() {
		return this.firstValue == this.secondeValue;
	}

	public void run() {
		firstValue = 0;
		secondeValue = 0;
		try {
			workMethod();
		} catch (InterruptedException e) {
			System.out.println("interrupted while in workMethod()");
		}
		
	}
	
	private void workMethod() throws InterruptedException {
		int value = 1;
		while(true) {
			stepOne(value);
			stepTwo(value);
			value++;
			Thread.sleep(200);
		}
	}
	
	private void stepOne(int newValue) throws InterruptedException {
		firstValue = newValue;
		Thread.sleep(300);
	}
	
	private void stepTwo(int newValue) throws InterruptedException {
		secondeValue = newValue;
	}
	
	public static void main(String[] args) {
		DeprecatedSuspendResume dsr = new DeprecatedSuspendResume();
		Thread t = new Thread(dsr);
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++) {
//			t.suspend();
			System.out.println("dsr.areValuesEqual()=" + dsr.areValuesEqual());
//			t.resume();
			try {
				Thread.sleep((long)(Math.random() * 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.exit(0);
	}

}
