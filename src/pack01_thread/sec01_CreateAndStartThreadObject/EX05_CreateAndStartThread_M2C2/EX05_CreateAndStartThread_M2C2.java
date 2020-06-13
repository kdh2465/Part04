package pack01_thread.sec01_CreateAndStartThreadObject.EX05_CreateAndStartThread_M2C2;

class SMIFileRunnable implements Runnable {
	@Override
	public void run() {
		// (자막 번호) 하나~다섯 저장 출력
		String[] strArray = new String[] { "하나", "둘", "셋", "넷", "다섯" };
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
		}
		for (int i = 0; i < strArray.length; i++) {
			System.out.println("(자막) " + strArray[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

class VideoFileRunnable implements Runnable {
	@Override
	public void run() {
		// (비디오프레임번호) 1~5 저장 + 출력
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("(비디오 프레임) " + intArray[i] + "-");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class EX05_CreateAndStartThread_M2C2 {
	public static void main(String[] args) {

		// Runnable 생성
		Runnable smiFileRunnable = new SMIFileRunnable();
		Runnable videoFileRunnable = new VideoFileRunnable();
		// Thread 생성
		Thread myThread1 = new Thread(smiFileRunnable);
		Thread myThread2 = new Thread(videoFileRunnable);
		// Thread 실행
		myThread1.start();
		myThread2.start();

	}	
}
