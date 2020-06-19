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
		//# 멀티캐스트 (224.0.0.0~239.255.255.255) : multicastSocket 클래스
		
		//#1. MulticastSocket 객체 생성
		MulticastSocket mcs1 = null;
		MulticastSocket mcs2 = null;
		MulticastSocket mcs3 = null;
		
		try {
			mcs1 = new MulticastSocket(); //비어있는 포트로 자동 바인딩
			mcs2 = new MulticastSocket(10000);
			mcs3 = new MulticastSocket(new InetSocketAddress("localhost",20000)); //일반적으로 멀티캐스트에서는 포트만 지정
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		System.out.println(mcs1.getLocalSocketAddress()); //0.0.0.0/0.0.0.0:50550
		System.out.println(mcs2.getLocalSocketAddress()); //0.0.0.0/0.0.0.0:10000
		System.out.println(mcs3.getLocalSocketAddress()); //127.0.0.1:10000
		System.out.println();
		
		
		//#2. MulticastSocket 주요 메서드
		
		//@2-1. getTimeToLive(), setTimeToLive(); 0~255까지 가능 (이외 IllegalArgumentException 발생) : 숫자의 의미 (통과하는 단말(스위치, 라우터 등) : 1인 경우는 절대 로컬 네트워크를 빠져나갈 수 없다.
		try {
			System.out.println("TimeToLive: " + mcs1.getTimeToLive()); //1
			mcs1.setTimeToLive(50);
			System.out.println("TimeToLive: " + mcs1.getTimeToLive()); //50
		} catch (IOException e1) {}
		System.out.println();
		
		//@2-2. joinGroup(InetAddress), leaveGroup(InetAddress) : InetAddress: (224.0.0.0~239.255.255.255) : 멀티캐스트 내용을 수신하기 위해 그룹에 조인하거나 탈퇴
		//      send(DatagramPacket), receive(DatagramPacket) : 멀티캐스트 그룹으로 데이터그램 패킷의 전송 및 수신
		try {
			
			mcs1.joinGroup(InetAddress.getByName("234.234.234.234"));
			mcs2.joinGroup(InetAddress.getByName("234.234.234.234"));
						
			byte[] sendData = "안녕하세요".getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("234.234.234.234"), 10000);			
			mcs1.send(sendPacket);
			
			byte[] receivedData = new byte[65508];
			DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);//, InetAddress.getByName("234.234.234.234"), 10000);
			mcs2.setSoTimeout(1000);
			mcs2.receive(receivedPacket);
			System.out.println("수신데이터: "+ new String(receivedPacket.getData()).trim() + "  송신지 주소: "+receivedPacket.getSocketAddress());
			
			mcs1.leaveGroup(InetAddress.getByName("234.234.234.234"));
			mcs2.leaveGroup(InetAddress.getByName("234.234.234.234"));
						
		} 
		catch (UnknownHostException e1) {e1.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
								
//		//@2-3. setInterface(), getInterface() 여러장의 lan카드를 사용하는 경우 특정 lan카드로의 바인딩 지정을 위해 사용
//		try {			
//			mcs1.setInterface(InetAddress.getByName("localhost"));
//			System.out.println(mcs1.getInterface()); //127.0.0.1
//		} catch (SocketException | UnknownHostException e) {}
//		System.out.println();
	
	}
}
