package pack04_javanetwork.sec03_UDPCommunication.EX11_NonConnectedUDP_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class EX11_NonConnectedUDP_Text_ClientA {
	public static void main(String[] args) {
		System.out.println("<<ClientA>> - Text");
		
		//#1. DatagramSocket 생성(binding 포함)
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10000);
		} catch (SocketException e) {}
		
		//#2. 전송데이터 생성 + Datagrampacket 생성(수신지 주소 포함)		
		byte[] sendData = "안녕하세요".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, new InetSocketAddress("127.0.0.1", 20000));
		
		//#3. 데이터그램패킷 전송
		try {
			System.out.println("송신데이터 : " + new String(sendPacket.getData()).trim());
			ds.send(sendPacket);
		} catch (IOException e) {}
		
		//#4. 데이터그램 패킷 수신
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {
			ds.receive(receivedPacket);
		} catch (IOException e) {}
		System.out.println("수신데이터 : " + new String(receivedPacket.getData()).trim());
		
	}
}
