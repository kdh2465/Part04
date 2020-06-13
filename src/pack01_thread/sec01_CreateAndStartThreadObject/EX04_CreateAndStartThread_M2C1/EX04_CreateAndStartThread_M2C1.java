package pack01_thread.sec01_CreateAndStartThreadObject.EX04_CreateAndStartThread_M2C1;

class SMIFileRunnable implements Runnable {
	@Override
	public void run() {
		// (자막 번호) 하나~다섯 저장 출력
		String[] strArray = new String[] { "하나", "둘", "셋", "넷", "다섯" };		
		try {Thread.sleep(10);} catch (InterruptedException e1) {} //자막이 약간 늦게 나오게 하기 위해서 추가		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println("(자막) " + strArray[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}

public class EX04_CreateAndStartThread_M2C1 {
	public static void main(String[] args) {
		
		//SMIFileRunnable 생성 및 실행
	    Runnable smiFileRunnable = new SMIFileRunnable();
	    //smiFileRunnable.start(); //오류
	    Thread thread = new Thread(smiFileRunnable);
	    thread.start();
	    
	    //(비디오프레임번호) 1~5 저장 + 출력
	    int[] intArray = new int[] {1,2,3,4,5};
	    for (int i=0; i<intArray.length; i++) {
	    	System.out.print("(비디오 프레임) " + intArray[i]+"-");
	      try { Thread.sleep(200); } catch (InterruptedException e) { }
	    }

	}
	
}
