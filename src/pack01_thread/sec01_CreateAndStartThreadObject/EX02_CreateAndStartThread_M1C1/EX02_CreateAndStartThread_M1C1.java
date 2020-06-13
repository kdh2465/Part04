package pack01_thread.sec01_CreateAndStartThreadObject.EX02_CreateAndStartThread_M1C1;

class SMIFileThread extends Thread {
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

public class EX02_CreateAndStartThread_M1C1 {
	public static void main(String[] args) {
		
		//SMIFileThread 생성 및 실행
	    Thread smiFileThread = new SMIFileThread();
	    smiFileThread.start();
	     
	    //(비디오프레임번호) 1~5 저장 + 출력
	    int[] intArray = new int[] {1,2,3,4,5};
	    for (int i=0; i<intArray.length; i++) {
	    	System.out.print("(비디오 프레임) " + intArray[i]+"-");
	      try { Thread.sleep(200); } catch (InterruptedException e) { }
	    }

	}
	
}
