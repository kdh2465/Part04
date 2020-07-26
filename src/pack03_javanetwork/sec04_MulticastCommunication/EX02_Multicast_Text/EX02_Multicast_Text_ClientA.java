package pack03_javanetwork.sec04_MulticastCommunication.EX02_Multicast_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/*Multicast ��ſ��� 1 : Ŭ���̾�Ʈ���� �ؽ�Ʈ(text) ���� [Client A]*/

public class EX02_Multicast_Text_ClientA {
	public static void main(String[] args) {
		System.out.println("<<ClientA>> - Text");
		//#1. ��Ƽĳ��Ʈ �ּ��� ����
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP ��Ʈ
		
		//#2. ��Ƽĳ��Ʈ ���� ���� (��������� ��Ƽĳ��Ʈ�ּҷ� ��Ŷ�� �����ϱ� ���ؼ��� ��Ƽĳ��Ʈ������ �����Ͽ� send)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort); 
		} catch (IOException e) {}
		
		//#3. ���� �����ͱ׷���Ŷ ���� (������ �ּ�  ��Ƽĳ��Ʈ ���� �ּ�)
		byte[] sendData="�ȳ��ϼ���!(ClientA)".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastAddress, multicastPort);
		
		//#4. send() �޼���� ������ ����
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);			
		} catch (IOException e) {}
		
		//#5. ��Ƽĳ��Ʈ �׷쿡 ���� (���� ��Ʈ��ȣ�� ������ ������ ����)	
		try {
			mcs.joinGroup(multicastAddress); //���������� ������ ��Ƽĳ��Ʈ�� �����ϴ� ��Ŷ �� ��Ʈ�� 10000�� �� ���� �ްڴ�.
		} catch (IOException e) {}
		
		//#6. ���� ���� �����ͱ׷��� ������ ����ִ� ������ũ�� ��ü ���� (�ִ� ũ��)
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		
		//#7. receive() �޼���� ������ ����
		try {
			mcs.receive(receivedPacket);
		} catch (IOException e) {}
		
		System.out.println("������ �ּ�: "+ receivedPacket.getSocketAddress());
		System.out.println("������ ����: "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim());
						
		//#8. ��Ƽĳ��Ʈ �׷� ������
		try {
			mcs.leaveGroup(multicastAddress); //leave�� ���� ������ �ڽ��� ���� �޼����� �ٽ� �ڽŵ� ����
		} catch (IOException e1) {}
		
		//#9. ���� �ݱ�
		mcs.close();
		
	}
}
