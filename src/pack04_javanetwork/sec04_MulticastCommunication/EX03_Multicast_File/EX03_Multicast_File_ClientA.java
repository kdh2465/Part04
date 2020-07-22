package pack04_javanetwork.sec04_MulticastCommunication.EX17_Multicast_File;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class EX17_Multicast_File_ClientA {
	public static void main(String[] args) {
		
		System.out.println("<<ClientA>> - File");
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
		
		//#3. 파일 로딩
		File file = new File("src/pack04_javanetwork/common_files/sendImageUsingMulticast.jpg");
		FileInputStream fis=null;
		try {
		  fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {}
		BufferedInputStream bis = new BufferedInputStream(fis);

		//#4. 2048 사이즈로 나누어 데이터그램패킷 연속 전송
		//@4-1. 파일전송 시작 사인 전송
		System.out.println(file.getName() + " 파일 전송 시작");
		String startSign = "/start";
		DatagramPacket sendPacket = new DatagramPacket(startSign.getBytes(), startSign.length(), multicastAddress, multicastPort);
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);
		} catch (IOException e1) {}
		
		//@4-2. 실제 파일 데이터 전송
		int len;
		byte[] filedata = new byte[2048]; // 최대는 65508byte이지만 안정적 네트워크 통신을 위해서 2048byte씩 잘라서 전송
		try {
			while ((len = bis.read(filedata)) != -1) {
				sendPacket = new DatagramPacket(filedata, len, multicastAddress, multicastPort);
				mcs.send(sendPacket);
			}
		} catch (IOException e) {}
		
		//@4-3. 파일전송 종료 사인 전송
		String endSign = "/end";
		sendPacket = new DatagramPacket(endSign.getBytes(), endSign.length(), multicastAddress, multicastPort);
		try {
			mcs.send(sendPacket);
		} catch (IOException e1) {}
		
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
		System.out.println("수신데이터: "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim());
						
		//#8. 멀티캐스트 그룹 나가기
		try {
			mcs.leaveGroup(multicastAddress); //leave를 하지 않으면 자신이 보낸 메세지를 다시 자신도 받음
		} catch (IOException e1) {}
		
		//#9. 소켓 닫기
		mcs.close();		
	}
}
