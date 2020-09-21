﻿package pack03_javanetwork.sec03_UDPCommunication.EX03_NonConnectedUDP_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*UDP 통신예제 1 : 클라이언트간 텍스트(text) 전송 (비연결통신) [Client B]*/

public class EX03_NonConnectedUDP_Text_ClientB {
	public static void main(String[] args) {
		System.out.println("<<ClientB>> - Text");
		
		//#1. DatagramSocket 생성(binding 포함)
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(20000);
		} catch (SocketException e) {}
		
		//#2. 데이터그램 패킷 수신
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {
			ds.receive(receivedPacket);
		} catch (IOException e) {}
		System.out.println("수신데이터 : " + new String(receivedPacket.getData()).trim());
		
		//#3. 전송데이터 생성 + Datagrampacket 생성(수신지 주소 = 수신 패킷의 원격지 정보 추출)		
		byte[] sendData = "반갑습니다.".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivedPacket.getSocketAddress());
		
		//#4. 데이터그램패킷 전송
		try {
			System.out.println("송신데이터 : " + new String(sendPacket.getData()).trim());
			ds.send(sendPacket);
		} catch (IOException e) {}
		
	}
}
