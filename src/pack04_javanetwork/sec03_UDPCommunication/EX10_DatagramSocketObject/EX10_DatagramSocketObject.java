package pack04_javanetwork.sec03_UDPCommunication.EX10_DatagramSocketObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EX10_DatagramSocketObject {
	public static void main(String[] args) {
		
		//#1. DatagramSocket ��ü ����
		DatagramSocket ds1=null, ds2=null, ds3=null, ds4=null;
		try {
			//@1-1. port������/port�� ���� 
			ds1 = new DatagramSocket(); //���� ȣ��Ʈ�� ����ִ� ��Ʈ�� �ڵ� ���ε�			
			ds2 = new DatagramSocket(10000); //���� ȣ��Ʈ�� ����ִ� ��Ʈ�� �ڵ� ���ε�			
			
			//@1-2. ���ε� �ּ� ����			
			ds3 = new DatagramSocket(10001, InetAddress.getByName("localhost"));
			ds4 = new DatagramSocket(new InetSocketAddress("localhost", 10002));
			
		} catch (SocketException | UnknownHostException e) {e.printStackTrace();}
		
		//#2. DatagramSocket �޼���
		
		//@2-1. ������ ���ε� �ּ� ����
		System.out.println("ds1 ���ε� ���� : "+ds1.getLocalAddress()+":"+ds1.getLocalPort());
		System.out.println("ds2 ���ε� ���� : "+ds2.getLocalAddress()+":"+ds2.getLocalPort());
		System.out.println("ds3 ���ε� ���� : "+ds3.getLocalAddress()+":"+ds3.getLocalPort());
		System.out.println("ds4 ���ε� ���� : "+ds4.getLocalAddress()+":"+ds4.getLocalPort());
		System.out.println();
		
		//@2-2. ������ �ּ� ���� (connect()�� ��쿡�� ����� ������ �ּ� ����)
		System.out.println("������ �ּ� ����: "+ds4.getInetAddress()+":"+ds4.getPort());		
		try {
			ds4.connect(new InetSocketAddress("localhost", 10002));
		} catch (SocketException e2) {}
		System.out.println("������ �ּ� ����: "+ds4.getInetAddress()+":"+ds4.getPort());
		ds4.disconnect();
		System.out.println();		
		
		//@2-3. send(), connect(), disconnect();
		
		//@2-3-0. ������Ŷ 2�� (������ �ּҰ� ���� ��Ŷ + ������ �ּҰ� �ִ� ��Ŷ)
		byte[] data1 = "������ �ּҰ� ���� �����ͱ׷� ��Ŷ".getBytes();
		byte[] data2 = "������ �ּҰ� �ִ� �����ͱ׷� ��Ŷ".getBytes();
		DatagramPacket dp1 = new DatagramPacket(data1, data1.length);
		DatagramPacket dp2 = new DatagramPacket(data2, data2.length, new InetSocketAddress("localhost", 10002));


		try {
			//@2-3-1. ������ �ּҰ� ���� ��Ŷ ���� = connect() + send() + disconnect();
			
			//ds1.send(dp1); //�Ұ���: ������ connect�� �� ���� + ��Ŷ�� ������ �ּ� ���� (NullPointerException)
			//ds2.send(dp1); //�Ұ���: ������ connect�� �� ���� + ��Ŷ�� ������ �ּ� ���� (NullPointerException)
			//ds3.send(dp1); //�Ұ���: ������ connect�� �� ���� + ��Ŷ�� ������ �ּ� ���� (NullPointerException)
						
			ds1.connect(new InetSocketAddress("localhost", 10002));
			ds2.connect(new InetSocketAddress("localhost", 10002));
			ds3.connect(new InetSocketAddress("localhost", 10002));
			
			ds1.send(dp1); //����
			ds2.send(dp1); //����
			ds3.send(dp1); //����
			
			ds1.disconnect();
			ds2.disconnect();
			ds3.disconnect();
			
			//@2-3-2. ������ �ּҰ� �ִ� ��Ŷ ���� = send();						
			ds1.send(dp2); //����
			ds2.send(dp2); //����
			ds3.send(dp2); //����
			
			ds3.connect(new InetSocketAddress("localhost", 10002));
			ds3.send(dp2); //��, ������ connect()�� ��� ��Ŷ ����� �ּҿ� ��Ŷ�� �������� ���ƾ� �� (�ƴ� ���  IllegalArgumentException)
			ds3.disconnect();
			
		} catch (IOException e2) {}
		
		//@2-4. receive()	
		byte[] receivedData = new byte[65508];
		DatagramPacket dp = new DatagramPacket(receivedData, receivedData.length);
		try {
			for(int i=0; i<7; i++) {
				ds4.receive(dp);
				System.out.println("�۽��� ���� "+dp.getAddress()+":"+dp.getPort()+" -> "+	new String(dp.getData()).trim());				
			}			
		} catch (IOException e2) {}
		System.out.println();
	
		//@2-5. �۽� �� ���� ���� ũ��
		try {
			System.out.println("�۽Ź���ũ��"+ds1.getSendBufferSize()+", ���Ź���ũ��"+ds1.getReceiveBufferSize());
		} catch (SocketException e) {}		
		
	}
}
