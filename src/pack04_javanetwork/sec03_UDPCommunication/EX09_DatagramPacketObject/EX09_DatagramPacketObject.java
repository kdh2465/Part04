package pack04_javanetwork.sec03_UDPCommunication.EX09_DatagramPacketObject;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class EX09_DatagramPacketObject {
	public static void main(String[] args) {
		
		//#0. �۽ŵ�����: �ִ����Ʈ�� 65508 byte (64Kbyte) : ipv4 (65536-20(IP header)-8(UDP header)=65505)
		byte[] buf = "UDP-�����ͱ׷���Ŷ".getBytes();
		
		//#1. DatagramPacket ��ü ����
		
		//@1-1. ������ �ּҰ� ���� DatagramPacket
		DatagramPacket dp1 = new DatagramPacket(buf, buf.length); //UDP-�����ͱ׷���Ŷ
		DatagramPacket dp2 = new DatagramPacket(buf, 4, buf.length-4); //�����ͱ׷���Ŷ (��, getData()�� ��ü ����)

		
		//@1-2. ������ �ּҰ� InetAddress�� port�� ���ԵǾ� �ִ� ���
		DatagramPacket dp3=null, dp4=null;
		try {
			dp3 = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10000); //data=UDP-�����ͱ׷���Ŷ
			dp4 = new DatagramPacket(buf, 4, buf.length-4, InetAddress.getByName("localhost"), 10000); //data=�����ͱ׷���Ŷ
		} catch (UnknownHostException e) {}
		
		//@1-3. ������ �ּҰ� SocketAddress�� ���ԵǾ� �ִ� ���
		DatagramPacket dp5=null, dp6=null;
		dp5 = new DatagramPacket(buf, buf.length, new InetSocketAddress("localhost", 10000));
		dp6 = new DatagramPacket(buf, 4, buf.length-4, new InetSocketAddress("localhost", 10000));
		
		//#2. DatagramPacket �ֿ� �޼���
		
		//@2-1. getAddress(), getPort(), getSocketAddress()
		System.out.println("������ IP   : " + dp1.getAddress()); //null
		System.out.println("������ Port : " + dp1.getPort()); //-1
		//System.out.println("������ SocketAddress : " + dp1.getSocketAddress()); //IllegalArgumentException �߻�
		System.out.println("������ IP   : " + dp3.getAddress()); //localhost/127.0.0.1
		System.out.println("������ Port : " + dp3.getPort()); //10000
		System.out.println("������ SocketAddress : " + dp3.getSocketAddress()); //localhost/127.0.0.1:10000
		System.out.println();
		
		//@2-2. getData(). setData(), getOffset(), getLength()
		System.out.println("���Ե����� : "+new String(dp1.getData())); //UDP-�����ͱ׷���Ŷ
		System.out.println("���Ե����� : "+new String(dp2.getData())); //UDP-�����ͱ׷���Ŷ ���� �����ʹ� ù��° �Ű������� ������ (�� ��ü ������)		
		System.out.println("���Ե����� : "+new String(dp2.getData(),dp2.getOffset(),dp2.getLength())); //�����ͱ׷���Ŷ		
		dp1.setData("�ȳ��ϼ���".getBytes());
		System.out.println("���Ե����� : "+new String(dp1.getData())); //�ȳ��ϼ���
			
	}
}
