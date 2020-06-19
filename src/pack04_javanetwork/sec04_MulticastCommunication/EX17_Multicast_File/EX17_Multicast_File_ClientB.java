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
		//#1. ��Ƽĳ��Ʈ �ּ��� ����
		InetAddress multicastAddress = null;
		try {
			multicastAddress = InetAddress.getByName("234.234.234.234");
		} catch (UnknownHostException e) {}
		int multicastPort = 10000; //UDP ��Ʈ
		
		//#2. ��Ƽĳ��Ʈ���� ���� (�̶� �����ϰ��� �ϴ� ��Ʈ ��ȣ ���ε�) (���۸� �ϴ� ���� ��Ʈ �ʿ� ����)
		MulticastSocket mcs = null;
		try {
			mcs = new MulticastSocket(multicastPort);
		} catch (IOException e1) {}
		
		//#3. ��Ƽĳ��Ʈ �׷쿡 ���� (���� ��Ʈ��ȣ�� ������ ������ ����)	
		try {
			mcs.joinGroup(multicastAddress); // ���������� ������ ��Ƽĳ��Ʈ�� �����ϴ� ��Ŷ �� ��Ʈ�� 10000�� �� ���� �ްڴ�.
		} catch (IOException e) {}

		//#4. ���������� ���� ���� ��� ��Ʈ�� ����
		File file = new File("src/pack04_javanetwork/common_files/receivedImageUsingMulticast.jpg");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {}
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		//#5. �����±׿� ���±� ���� + ���� ���� �����ͱ׷��� ������ ����ִ� ������ũ�� ��ü ���� (�ִ� ũ��) + ���� ������ ����
		String startSign = "/start";
		String endSign = "/end";
		
		byte[] receivedData = new byte[65508];
		DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

		try {
			mcs.receive(receivedPacket);
			if (new String(receivedPacket.getData(), 0, receivedPacket.getLength()).trim().equals(startSign)) {
				System.out.println(file.getName() + " �̸����� ���� ���� ����");
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
		System.out.println("���� ���� �Ϸ�");

		// #6. ��Ƽĳ��Ʈ �׷� ������
		try {
			mcs.leaveGroup(multicastAddress); // leave�� ���� ������ �ڽ��� ���� �޼����� �ٽ� �ڽŵ� ����
		} catch (IOException e1) {}

		// #7. ���� �����ͱ׷���Ŷ ���� (ȸ�ſ�)
		byte[] sendData="�������ۿϷ�".getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multicastAddress, multicastPort);
		
		//#8. send()�� ȸ��		 
		try {
			mcs.setTimeToLive(1);
			mcs.send(sendPacket);
		} catch (IOException e) {}
		
		//#9. ���� �ݱ�
		mcs.close();
				
	}
}
