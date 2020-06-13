package pack01_thread.sec04_TheradStates.EX18_TimedWaiting_SleepInterrupt;

class MyThread extends Thread {
	@Override
	public void run() {
		try { 
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(" --sleep() 중 interrupt 발생--");
			for (long i = 0; i < 1000000000L; i++) {} //RUNNABLE
		}
	}
}

public class EX18_TimedWaiting_SleepInterrupt {
	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
	    myThread.start();
	    
	    //#Thread.sleep() 
	    try {Thread.sleep(100);} catch (InterruptedException e) {} //run()이 시작되기까지 시간여유
	    System.out.println("MyThread State : " + myThread.getState()); //TIMED_WAITING
	    
	    //#interrupt()
	    myThread.interrupt();
	    try {Thread.sleep(100);} catch (InterruptedException e) {} //예외발생까지의 시간여유
	    System.out.println("MyThread State : " + myThread.getState()); //RUNNABLE
	    
	}
}
