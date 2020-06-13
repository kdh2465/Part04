package pack01_thread.sec04_TheradStates.EX20_BlockedState;

class MyClass{
	synchronized void syncMethod() {
		System.out.println(Thread.currentThread().getName());
		for(long i=0; i<1000000000L; i++) {}
	}
}

public class EX20_BlockedState {
	public static void main(String[] args) throws InterruptedException {
		MyClass mc = new MyClass();
		Thread t1 = new Thread("thread1") {
			public void run() {
				mc.syncMethod();
			}
		};
		Thread t2 = new Thread("thread2") {
			public void run() {
				mc.syncMethod();
			}
		};
		Thread t3 = new Thread("thread3") {
			public void run() {
				mc.syncMethod();
			}
		};
		t1.start();
		t2.start();
		t3.start();
		while(true) {
			Thread.sleep(500);
			System.out.println("t1 : "+t1.getState());
			System.out.println("t2 : "+t2.getState());
			System.out.println("t3 : "+t3.getState());
			if(t1.getState()==Thread.State.TERMINATED
					&& t2.getState()==Thread.State.TERMINATED 
					&& t3.getState()==Thread.State.TERMINATED)
				break;
		}
	}
}

