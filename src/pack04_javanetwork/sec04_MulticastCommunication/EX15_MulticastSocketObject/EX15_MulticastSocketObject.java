package pack04_javanetwork.sec04_MulticastCommunication.EX15_MulticastSocketObject;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EX15_MulticastSocketObject {
	public static void main(String[] args) {
		//# ��Ƽĳ��Ʈ (224.0.0.0~239.255.255.255) : multicastSocket Ŭ����
		
		//#1. MulticastSocket ��ü ����
		MulticastSocket mcs1 = null;
		MulticastSocket mcs2 = null;
		MulticastSocket mcs3 = null;
		
		try {
			mcs1 = new MulticastSocket(); //����ִ� ��Ʈ�� �ڵ� ���ε�
			mcs2 = new MulticastSocket(10000);
			mcs3 = new MulticastSocket(new InetSocketAddress("localhost",20000)); //�Ϲ������� ��Ƽĳ��Ʈ������ ��Ʈ�� ����
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println(mcs1.getLocalSocketAddress()); //0.0.0.0/0.0.0.0:50550
		System.out.println(mcs2.getLocalSocketAddress()); //0.0.0.0/0.0.0.0:10000
		System.out.println(mcs3.getLocalSocketAddress()); //127.0.0.1:10000
		System.out.println();
		
		
		//#2. MulticastSocket �ֿ� �޼���
		
		//@2-1. getTimeToLive(), setTimeToLive(); 0~255���� ���� (�̿� IllegalArgumentException �߻�) : ������ �ǹ� (����ϴ� �ܸ�(����ġ, ����� ��) : 1�� ���� ���� ���� ��Ʈ��ũ�� �������� �� ����.
		try {
			System.out.println("TimeToLive: " + mcs1.getTimeToLive()); //1
			mcs1.setTimeToLive(50);
			System.out.println("TimeToLive: " + mcs1.getTimeToLive()); //50
		} catch (IOException e1) {}
		System.out.println();
		
		//@2-2. joinGroup(InetAddress), leaveGroup(InetAddress) : InetAddress: (224.0.0.0~239.255.255.255) : ��Ƽĳ��Ʈ ������ �����ϱ� ���� �׷쿡 �����ϰų� Ż��
		//      send(DatagramPacket), receive(DatagramPacket) : ��Ƽĳ��Ʈ �׷����� �����ͱ׷� ��Ŷ�� ���� �� ����
		try {
			
			mcs1.joinGroup(InetAddress.getByName("234.234.234.234"));
			mcs2.joinGroup(InetAddress.getByName("234.234.234.234"));
						
			byte[] sendData = "�ȳ��ϼ���".getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("234.234.234.234"), 10000);			
			mcs1.send(sendPacket);
			
			byte[] receivedData = new byte[65508];
			DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);//, InetAddress.getByName("234.234.234.234"), 10000);
			mcs2.setSoTimeout(1000);
			mcs2.receive(receivedPacket);
			System.out.println("���ŵ�����: "+ new String(receivedPacket.getData()).trim() + "  �۽��� �ּ�: "+receivedPacket.getSocketAddress());
			
			mcs1.leaveGroup(InetAddress.getByName("234.234.234.234"));
			mcs2.leaveGroup(InetAddress.getByName("234.234.234.234"));
						
		} 
		catch (UnknownHostException e1) {e1.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
								
//		//@2-3. setInterface(), getInterface() �������� lanī�带 ����ϴ� ��� Ư�� lanī����� ���ε� ������ ���� ���
//		try {			
//			mcs1.setInterface(InetAddress.getByName("localhost"));
//			System.out.println(mcs1.getInterface()); //127.0.0.1
//		} catch (SocketException | UnknownHostException e) {}
//		System.out.println();
	
	}
}
