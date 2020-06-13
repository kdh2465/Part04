package pack01_thread.sec03_SynchronizedMethodAndBlock.EX15_KeyObjectCase_2;

class MyData {
	synchronized void abc() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "sec");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	synchronized void bcd() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "초");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	void cde() {
		synchronized (new Object()) {
			for (int i = 0; i < 3; i++) {
				System.out.println(i + "번째");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}
		} 
	}
}

public class EX15_KeyObjectCase_2 {
	public static void main(String[] args) {
		//#공유객체
		MyData myData = new MyData();
		
		// #Thread 1 : abc() 실행
		new Thread() {
			public void run() {
				myData.abc();
			}
		}.start();

		// #Thread 2 : bcd() 실행
		new Thread() {
			public void run() {
				myData.bcd();
			}
		}.start();

		// #Thread 3 : cde() 실행
		new Thread() {
			public void run() {
				myData.cde();
			}
		}.start();
	}
}
