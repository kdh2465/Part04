package pack01_thread.sec03_SynchronizedMethodAndBlock.EX11_TheNeedForSynchronized;
//#. 공유객체
class MyData {
	private int data = 3;
	public void setData(int data) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void plusData() {
		setData(data + 1);
	}
}
//# 공유객체 사용 쓰레드
class PlusThread extends Thread {
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData = myData;
	}
	@Override
	public void run() {
		myData.plusData();
		System.out.println(getName() + "실행결과: " + myData.getData());
	}
}

public class EX11_TheNeedForSynchronized {
	public static void main(String[] args) {
	    //#공유객체
		MyData myData = new MyData();
		
		//#plusThread1
	    Thread plusThread1 = new PlusThread(myData);
	    plusThread1.setName("plusThread1");
	    plusThread1.start();
	    
	    try { Thread.sleep(1000); } 
	    catch (InterruptedException e) {}
	    
	    //#plusThread2
	    Thread plusThread2 = new PlusThread(myData);
	    plusThread2.setName("plusThread2");
	    plusThread2.start();
	}
}
