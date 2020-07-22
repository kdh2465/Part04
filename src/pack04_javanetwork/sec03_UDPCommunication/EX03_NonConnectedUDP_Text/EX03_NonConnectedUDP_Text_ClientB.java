package pack04_javanetwork.sec03_UDPCommunication.EX11_NonConnectedUDP_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class EX11_NonConnectedUDP_Text_ClientB {
	public static void main(String[] args) {
		System.out.println("<<ClientB>> - Text");
		
		//#1. DatagramSocket ����(binding ����)
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(20000);
		} catch (SocketException e) {}
		
		//#2. �����ͱ׷� ��Ŷ ����
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {
			ds.receive(receivedPacket);
		} catch (IOException e) {}
		System.out.println("���ŵ����� : " + new String(receivedPacket.getData()).trim());
		
		//#3. ���۵����� ���� + Datagrampacket ����(������ �ּ� = ���� ��Ŷ�� ������ ���� ����)		
		byte[] sendData = "�ݰ����ϴ�.".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivedPacket.getSocketAddress());
		
		//#4. �����ͱ׷���Ŷ ����
		try {
			System.out.println("�۽ŵ����� : " + new String(sendPacket.getData()).trim());
			ds.send(sendPacket);
		} catch (IOException e) {}
		
	}
}
