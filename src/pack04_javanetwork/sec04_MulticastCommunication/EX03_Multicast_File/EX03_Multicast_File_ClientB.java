package pack04_javanetwork.sec04_MulticastCommunication.EX17_Multicast_File;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class EX17_Multicast_File_ClientB {
	public static void main(String[] args) {
		
		System.out.println("<<ClientB>> - File");
		//#1. 멀티캐스트 주소지 생성
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP 포트
		
		//#2. 멀티캐스트소켓 생성 (이때 수신하고자 하는 포트 번호 바인딩) (전송만 하는 경우는 포트 필요 없음)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort);
		} catch (IOException e1) {}
		
		//#3. 멀티캐스트 그룹에 조인 (이후 포트번호가 맞으면 데이터 수신)	
		try {
			mcs.joinGroup(multicastAddress); // 개념적으로 가상의 멀티캐스트로 도착하는 패킷 중 포트가 10000인 건 나도 받겠다.
		} catch (IOException e) {}

		//#4. 파일저장을 위한 파일 출력 스트림 생성
		File file = new File("src/pack04_javanetwork/common_files/receivedImageUsingMulticast.jpg");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {}
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		//#5. 시작태그와 끝태그 설정 + 수신 받은 데이터그램을 저장할 비어있는 데이터크램 객체 생성 (최대 크기) + 실제 데이터 수신
		String startSign = "/start";
		String endSign = "/end";
		
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

		try {
			mcs.receive(receivedPacket);
			if (new String(receivedPacket.getData(), 0, receivedPacket.getLength()).trim().equals(startSign)) {
				System.out.println(file.getName() + " 이름으로 파일 수신 시작");
				while (true) {
					mcs.receive(receivedPacket);
					if (new String(receivedPacket.getData(), 0, receivedPacket.getLength()).trim().equals(endSign))
						break;
					bos.write(receivedPacket.getData(), 0, receivedPacket.getLength());
					bos.flush();
				}
			}
		} catch (IOException e) {}
		try {
			bos.close();
		} catch (IOException e1) {}
		System.out.println("파일 수신 완료");

		// #6. 멀티캐스트 그룹 나가기
		try {
			mcs.leaveGroup(multicastAddress); // leave를 하지 않으면 자신이 보낸 메세지를 다시 자신도 받음
		} catch (IOException e1) {}

		// #7. 전송 데이터그램패킷 생성 (회신용)
		byte[] sendData="파일전송완료".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastAddress, multicastPort);
		
		//#8. send()로 회신		 
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);
		} catch (IOException e) {}
		
		//#9. 소켓 닫기
		mcs.close();
				
	}
}
