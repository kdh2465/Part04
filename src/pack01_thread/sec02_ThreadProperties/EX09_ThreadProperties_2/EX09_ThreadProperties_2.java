package pack01_thread.sec02_ThreadProperties.EX09_ThreadProperties_2;

class MyThread extends Thread {
	@Override
	public void run() {
		for(long i=0; i<100000000; i++) {} //#�ణ�� �ð� ����
		System.out.println(getName() + " �켱����:" + getPriority());
	}
}

public class EX09_ThreadProperties_2 {
	public static void main(String[] args) {
		
		//#����. CPU Core �� ��������
		System.out.print("�ھ�� : ");
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		//#1. ����Ʈ(default) �켱����
		for (int i = 0; i < 3; i++) {
			Thread thread = new MyThread();
			thread.start();
		}
		
		try { Thread.sleep(200); } catch (InterruptedException e) {}
		
		//#2. �켱���� ����
		for (int i = 0; i < 10; i++) {
			Thread thread = new MyThread();
			thread.setName(i + " ��° ������");
			if (i == 9)
				thread.setPriority(Thread.MAX_PRIORITY);
			else 
				thread.setPriority(Thread.MIN_PRIORITY);
			
			thread.start();
		}
				
	}
}
