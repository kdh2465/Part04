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
		
		//#1. DatagramSocket ����(binding ����) + ���ϰ� ����
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10000);
			ds.connect(new InetSocketAddress("127.0.0.1",20000));
		} catch (SocketException e) {}
		
		
		//#2. ���� �ε�
		File file = new File("files/sendImageUsingUDP.jpg");			
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {		}
		BufferedInputStream bis = new BufferedInputStream(fis);		
		
		//#3. 2048 ������� ������ �����ͱ׷���Ŷ ���� ����
		//@3-1. �������� ���� ���� ����
		System.out.println(file.getName() + " ���� ���� ����");
		String startSign = "/start";
		DatagramPacket sendPacket = new DatagramPacket(startSign.getBytes(), startSign.length());		
		try {
			ds.send(sendPacket);
		} catch (IOException e1) {}
		
		//@3-2. ���� ���� ������ ����
		int len;
		byte[] filedata = new byte[2048]; //�ִ�� 65508byte������ ������ ��Ʈ��ũ ����� ���ؼ� 2048byte�� �߶� ����
		try {
			while((len = bis.read(filedata)) != -1) {
				sendPacket = new DatagramPacket(filedata, len);
				ds.send(sendPacket);
			}
		} catch (IOException e) {}
		
		//@3-3. �������� ���� ���� ����
		String endSign = "/end";
		sendPacket = new DatagramPacket(endSign.getBytes(), endSign.length());
		try {
			ds.send(sendPacket);
		} catch (IOException e1) {}
				
		//#4. �����ͱ׷� ��Ŷ ����
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {
			ds.receive(receivedPacket);
		} catch (IOException e) {}
		System.out.println("���ŵ����� : " + new String(receivedPacket.getData()).trim());
		
	}
}
