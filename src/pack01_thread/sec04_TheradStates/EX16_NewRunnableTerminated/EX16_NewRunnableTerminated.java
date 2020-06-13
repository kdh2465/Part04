package pack01_thread.sec04_TheradStates.EX16_NewRunnableTerminated;

public class EX16_NewRunnableTerminated {
	public static void main(String[] args) {
		//#.������ ���� 
		Thread.State state;
		
		//#1. ��ü���� (NEW)
	    Thread thread = new Thread() {
	      @Override
	      public void run() {
	        for(long i=0; i<1000000000L; i++) {}
	      }
	    };	    
	    state = thread.getState();
	    System.out.println("thread State : " + state); //NEW
	    
	    //#2. Thread ���� (RUNNABLE)
	    thread.start();
	    state = thread.getState();
	    System.out.println("thread State : " + state); //RUNNABLE
	    
	    //#3. Thread ���� (TERMINATED)
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
