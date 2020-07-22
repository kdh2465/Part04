package pack04_javanetwork.sec03_UDPCommunication.EX04_ConnectedUDP_File;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class EX04_ConnectedUDP_File_ClientB {
	public static void main(String[] args) {
		System.out.println("<<ClientB>> - File");
		
		//#1. DatagramSocket ����(binding ����) + ���ϰ� ����
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(20000);
			ds.connect(new InetSocketAddress("127.0.0.1",10000));
		} catch (SocketException e) {}
		
		//#2. ���������� ���� ���� ��� ��Ʈ�� ����
		File file = new File("src/pack04_javanetwork/common_files/receivedImageUsingUDP.jpg");			
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {}		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		//#3. �����ͱ׷� ��Ŷ ���� (�����±׿� ���±׸� �������� ���� ����)		
		String startSign = "/start";
		String endSign = "/end";
				
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length); 
		try {			
			ds.receive(receivedPacket);
			if(new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim().equals(startSign)) {
				System.out.println(file.getName() + " �̸����� ���� ���� ����");
				while(true) {
					ds.receive(receivedPacket);
					if(new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim().equals(endSign))
						break;					
					bos.write(receivedPacket.getData(), 0, receivedPacket.getLength());					
					bos.flush();
				}
			}
		} catch (IOException e) {}
		try {
			bos.close();
		} catch (IOException e1) {}
		
		//#4. ���۵����� ���� + Datagrampacket ����(������ �ּ� ����)		
		System.out.println("���� ���� �Ϸ�");
		byte[] sendData = "�������ۿϷ�".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length);
		
		try {
			ds.send(sendPacket);			
		} catch (IOException e) {}
		
	}
}
