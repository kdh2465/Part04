package pack01_thread.sec02_ThreadProperties.EX08_ThreadProperties_1;

public class EX08_ThreadProperties_1 {
	public static void main(String[] args) {
		
		//#1. ��ü �������� (currentThread()) + ������ �� (activeCount())
		Thread curThread = Thread.currentThread();
		System.out.println("���� ������ �̸�:"+curThread.getName());
		System.out.println("������ ��="+Thread.activeCount());
		
		//#2. ������ �̸� �ڵ� ����
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread();
			System.out.println(thread.getName());
			thread.start();
		}
		
		// #3. ������ �̸� ���� ����
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread();
			thread.setName(i+"��° ������");
			System.out.println(thread.getName());
			thread.start();
		}
		
		//#4. ������ �̸� �ڵ� ����
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread();
			System.out.println(thread.getName());
			thread.start();
		}	
		
		//#5. ������ ��		
		System.out.println("������ ��="+Thread.activeCount());		

	}
}
