package pack01_thread.sec01_CreateAndStartThreadObject.EX05_CreateAndStartThread_M2C2;

class SMIFileRunnable implements Runnable {
	@Override
	public void run() {
		// (�ڸ� ��ȣ) �ϳ�~�ټ� ���� ���
		String[] strArray = new String[] { "�ϳ�", "��", "��", "��", "�ټ�" };
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
		}
		for (int i = 0; i < strArray.length; i++) {
			System.out.println("(�ڸ�) " + strArray[i]);
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
		// (���������ӹ�ȣ) 1~5 ���� + ���
		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("(���� ������) " + intArray[i] + "-");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class EX05_CreateAndStartThread_M2C2 {
	public static void main(String[] args) {

		// Runnable ����
		Runnable smiFileRunnable = new SMIFileRunnable();
		Runnable videoFileRunnable = new VideoFileRunnable();
		// Thread ����
		Thread myThread1 = new Thread(smiFileRunnable);
		Thread myThread2 = new Thread(videoFileRunnable);
		// Thread ����
		myThread1.start();
		myThread2.start();

	}	
}
