package pack01_thread.EX01_TheNeedForThread;

public class EX01_TheNeedforThread {
	public static void main(String[] args) {
		
	    //(���������ӹ�ȣ) 1~5 ����
	    int[] intArray = new int[] {1,2,3,4,5};
	    //(�ڸ� ��ȣ) �ϳ�~�ټ� ����
	    String[] strArray = new String[] {"�ϳ�","��","��","��","�ټ�"};	   
	    
	    //(���������ӹ�ȣ) 1~5 ���
	    for (int i=0; i<intArray.length; i++) { 
	      System.out.println("(���� ������) " + intArray[i]);
	      try { Thread.sleep(200); } catch (InterruptedException e) { }
	    }
	    //(�ڸ� ��ȣ) �ϳ�~�ټ� ���
	    for (int i=0; i<strArray.length; i++) { 
	      System.out.println("(�ڸ�) "+ strArray[i]);
	      try { Thread.sleep(200); } catch (InterruptedException e) { }
	    }

	}
}
