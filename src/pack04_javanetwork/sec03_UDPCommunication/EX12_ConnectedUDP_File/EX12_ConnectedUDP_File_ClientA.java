package pack04_javanetwork.sec03_UDPCommunication.EX12_ConnectedUDP_File;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class EX12_ConnectedUDP_File_ClientA {
	public static void main(String[] args) {
		System.out.println("<<ClientA>> - File");
		
		//#1. DatagramSocket 생성(binding 포함) + 소켓간 연결
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10000);
			ds.connect(new InetSocketAddress("127.0.0.1",20000));
		} catch (SocketException e) {}
		
		
		//#2. 파일 로딩
		File file = new File("files/sendImageUsingUDP.jpg");			
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {		}
		BufferedInputStream bis = new BufferedInputStream(fis);		
		
		//#3. 2048 사이즈로 나누어 데이터그램패킷 연속 전송
		//@3-1. 파일전송 시작 사인 전송
		System.out.println(file.getName() + " 파일 전송 시작");
		String startSign = "/start";
		DatagramPacket sendPacket = new DatagramPacket(startSign.getBytes(), startSign.length());		
		try {
			ds.send(sendPacket);
		} catch (IOException e1) {}
		
		//@3-2. 실제 파일 데이터 전송
		int len;
		byte[] filedata = new byte[2048]; //최대는 65508byte이지만 안정적 네트워크 통신을 위해서 2048byte씩 잘라서 전송
		try {
			while((len = bis.read(filedata)) != -1) {
				sendPacket = new DatagramPacket(filedata, len);
				ds.send(sendPacket);
			}
		} catch (IOException e) {}
		
		//@3-3. 파일전송 종료 사인 전송
		String endSign = "/end";
		sendPacket = new DatagramPacket(endSign.getBytes(), endSign.length());
		try {
			ds.send(sendPacket);
		} catch (IOException e1) {}
				
		//#4. 데이터그램 패킷 수신
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {
			ds.receive(receivedPacket);
		} catch (IOException e) {}
		System.out.println("수신데이터 : " + new String(receivedPacket.getData()).trim());
		
	}
}
