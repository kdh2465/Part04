package pack04_javanetwork.sec04_MulticastCommunication.EX16_Multicast_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class EX16_Multicast_Text_ClientB {
	public static void main(String[] args) {
		
		System.out.println("<<ClientB>> - Text");		
		//#1. ��Ƽĳ��Ʈ �ּ��� ����
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP ��Ʈ
		
		//#2. ��Ƽĳ��Ʈ���� ���� (�̶� �����ϰ��� �ϴ� ��Ʈ ��ȣ ���ε�) (���۸� �ϴ� ���� ��Ʈ �ʿ� ����)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort);
		} catch (IOException e1) {}
		
		//#3. ��Ƽĳ��Ʈ �׷쿡 ���� (���� ��Ʈ��ȣ�� ������ ������ ����)	
		try {
			mcs.joinGroup(multicastAddress); //���������� ������ ��Ƽĳ��Ʈ�� �����ϴ� ��Ŷ �� ��Ʈ�� 10000�� �� ���� �ްڴ�.
		} catch (IOException e) {}
		
		//#4. ���� ���� �����ͱ׷��� ������ ����ִ� ������ũ�� ��ü ���� (�ִ� ũ��)
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		
		//#5. receive() �޼���� ������ ����
		try {
			mcs.receive(receivedPacket);
		} catch (IOException e) {}
		
		System.out.println("������ �ּ�: "+ receivedPacket.getSocketAddress());
		System.out.println("������ ����: "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim());
				
		//#6. ��Ƽĳ��Ʈ �׷� ������
		try {
			mcs.leaveGroup(multicastAddress); //leave�� ���� ������ �ڽ��� ���� �޼����� �ٽ� �ڽŵ� ����
		} catch (IOException e1) {}
		
		//#7. ���� �����ͱ׷���Ŷ ���� (ȸ�ſ�)
		byte[] sendData="�ݰ����ϴ�.(ClientB)".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastAddress, multicastPort);
		
		//#8. send()�� ȸ��		 
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);
		} catch (IOException e) {}
		
		//#9. ���� �ݱ�
		mcs.close();
				
	}
}
