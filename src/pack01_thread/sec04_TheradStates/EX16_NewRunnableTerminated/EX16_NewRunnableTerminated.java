package pack01_thread.sec04_TheradStates.EX16_NewRunnableTerminated;

public class EX16_NewRunnableTerminated {
	public static void main(String[] args) {
		//#.쓰레드 상태 
		Thread.State state;
		
		//#1. 객체생성 (NEW)
	    Thread thread = new Thread() {
	      @Override
	      public void run() {
	        for(long i=0; i<1000000000L; i++) {}
	      }
	    };	    
	    state = thread.getState();
	    System.out.println("thread State : " + state); //NEW
	    
	    //#2. Thread 시작 (RUNNABLE)
	    thread.start();
	    state = thread.getState();
	    System.out.println("thread State : " + state); //RUNNABLE
	    
	    //#3. Thread 종료 (TERMINATED)
	    //try {Thread.sleep(1000);} catch (InterruptedException e) {}
	    
	    try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    state = thread.getState();
	    System.out.println("thread State : " + state); //TERMINATED
	}
}
