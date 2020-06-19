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
		//#1. ��Ƽĳ��Ʈ �ּ��� ����
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP ��Ʈ
		
		//#2. ��Ƽĳ��Ʈ ���� ���� (��������� ��Ƽĳ��Ʈ�ּҷ� ��Ŷ�� �����ϱ� ���ؼ��� ��Ƽĳ��Ʈ������ �����Ͽ� send)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort); 
		} catch (IOException e) {}
		
		//#3. ���� �ε�
		File file = new File("src/pack04_javanetwork/common_files/sendImageUsingMulticast.jpg");
		FileInputStream fis=null;
		try {
		  fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {}
		BufferedInputStream bis = new BufferedInputStream(fis);

		//#4. 2048 ������� ������ �����ͱ׷���Ŷ ���� ����
		//@4-1. �������� ���� ���� ����
		System.out.println(file.getName() + " ���� ���� ����");
		String startSign = "/start";
		DatagramPacket sendPacket = new DatagramPacket(startSign.getBytes(), startSign.length(), multicastAddress, multicastPort);
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);
		} catch (IOException e1) {}
		
		//@4-2. ���� ���� ������ ����
		int len;
		byte[] filedata = new byte[2048]; // �ִ�� 65508byte������ ������ ��Ʈ��ũ ����� ���ؼ� 2048byte�� �߶� ����
		try {
			while ((len = bis.read(filedata)) != -1) {
				sendPacket = new DatagramPacket(filedata, len, multicastAddress, multicastPort);
				mcs.send(sendPacket);
			}
		} catch (IOException e) {}
		
		//@4-3. �������� ���� ���� ����
		String endSign = "/end";
		sendPacket = new DatagramPacket(endSign.getBytes(), endSign.length(), multicastAddress, multicastPort);
		try {
			mcs.send(sendPacket);
		} catch (IOException e1) {}
		
		//#5. ��Ƽĳ��Ʈ �׷쿡 ���� (���� ��Ʈ��ȣ�� ������ ������ ����)	
		try {
			mcs.joinGroup(multicastAddress); //���������� ������ ��Ƽĳ��Ʈ�� �����ϴ� ��Ŷ �� ��Ʈ�� 10000�� �� ���� �ްڴ�.
		} catch (IOException e) {}
		
		//#6. ���� ���� �����ͱ׷��� ������ ����ִ� ������ũ�� ��ü ���� (�ִ� ũ��)
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
		
		//#7. receive() �޼���� ������ ����
		try {
			mcs.receive(receivedPacket);
		} catch (IOException e) {}				
		System.out.println("���ŵ�����: "+ new String(receivedPacket.getData(),0,receivedPacket.getLength()).trim());
						
		//#8. ��Ƽĳ��Ʈ �׷� ������
		try {
			mcs.leaveGroup(multicastAddress); //leave�� ���� ������ �ڽ��� ���� �޼����� �ٽ� �ڽŵ� ����
		} catch (IOException e1) {}
		
		//#9. ���� �ݱ�
		mcs.close();		
	}
}
