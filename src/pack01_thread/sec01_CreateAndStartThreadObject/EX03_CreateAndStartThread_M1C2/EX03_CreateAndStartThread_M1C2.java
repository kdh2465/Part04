package pack01_thread.sec01_CreateAndStartThreadObject.EX03_CreateAndStartThread_M1C2;

class SMIFileThread extends Thread {
	@Override
	public void run() {
		// (�ڸ� ��ȣ) �ϳ�~�ټ� ���� ���
		String[] strArray = new String[] { "�ϳ�", "��", "��", "��", "�ټ�" };		
		try {Thread.sleep(10);} catch (InterruptedException e1) {} //�ڸ��� �ణ �ʰ� ������ �ϱ� ���ؼ� �߰�		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println("(�ڸ�) " + strArray[i]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}

class VideoFileThread extends Thread {
	@Override
	public void run() {
		// (���������ӹ�ȣ) 1~5 ���� + ���
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("(���� ������) " + intArray[i] + "-");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}

public class EX03_CreateAndStartThread_M1C2 {
	public static void main(String[] args) {
		
		//VideoFileThread + SMIFileThread ���� �� ����
		Thread videoFileThread = new VideoFileThread();
	    Thread smiFileThread = new SMIFileThread();
	    videoFileThread.start();
	    smiFileThread.start();
	    
	}	
}
