package pack03_javanetwork.sec04_MulticastCommunication.EX02_Multicast_Text;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/*Multicast 통신예제 1 : 클라이언트간의 텍스트(text) 전송 [Client A]*/

public class EX02_Multicast_Text_ClientA {
	public static void main(String[] args) {
		System.out.println("<<ClientA>> - Text");
		//#1. 멀티캐스트 주소지 생성
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP 포트
		
		//#2. 멀티캐스트 소켓 생성 (가상공간의 멀티캐스트주소로 패킷을 전송하기 위해서는 멀티캐스트소켓을 생성하여 send)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort); 
		} catch (IOException e) {}
		
		//#3. 전송 데이터그램패킷 생성 (수신지 주소  멀티캐스트 가상 주소)
		byte[] sendData="안녕하세요!(ClientA)".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastAddress, multicastPort);
		
		//#4. send() 메서드로 데이터 전송
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);			
		} catch (IOException e) {}
		
		//#5. 멀티캐스트 그룹에 조인 (이후 포트번호가 맞으면 데이터 수신)	
		try {
			mcs.joinGroup(multicastAddress); //개념적으로 가상의 멀티캐스트로 도착하는 패킷 중 포트가 10000인 건 나도 받겠다.
		} catch (IOException e) {}
		
		//#6. 수신 받은 데이터그램을 저장할 비어있는 데이터크램 객체 생성 (최대 크기)
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		
		//#7. receive() 메서드로 데이터 수신
		try {
			mcs.receive(receivedPacket);
		} catch (IOException e) {}
		
		System.out.println("보내온 주소: "+ receivedPacket.getSocketAddress());
		System.out.println("보내온 내용: "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim());
						
		//#8. 멀티캐스트 그룹 나가기
		try {
			mcs.leaveGroup(multicastAddress); //leave를 하지 않으면 자신이 보낸 메세지를 다시 자신도 받음
		} catch (IOException e1) {}
		
		//#9. 소켓 닫기
		mcs.close();
		
	}
}
