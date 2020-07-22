package pack04_javanetwork.sec02_TCPCommunication.EX01_SocketObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EX01_SocketObject {
	public static void main(String[] args) {
		//#1. Socket ��ü ���� 
		Socket socket1 = new Socket();
		Socket socket2 = null;
		Socket socket3 = null;
		Socket socket4 = null;
		Socket socket5 = null;
		try {
			socket2 = new Socket("www.naver.com", 80);
			socket3 = new Socket("www.naver.com", 80, InetAddress.getLocalHost(), 10000);
			socket4 = new Socket(InetAddress.getByName("www.naver.com"), 80);
			socket5 = new Socket(InetAddress.getByName("www.naver.com"), 80, InetAddress.getLocalHost(), 10000);			
		} 
		catch (UnknownHostException e) {} 
		catch (IOException e) {}
		
		//#2. Socket �޼���
		//@connect/������ �ּ�����
		System.out.println(socket1.getInetAddress()+":"+socket1.getPort()); //null:0
		try {
			socket1.connect(new InetSocketAddress("www.naver.com",80));
		} catch (IOException e) {}
		System.out.println(socket1.getInetAddress()+":"+socket1.getPort()); //www.naver.com/125.209.222.141
		System.out.println(socket2.getInetAddress()+":"+socket2.getPort()); //www.naver.com/125.209.222.141
		System.out.println();
		
		//@���� �ּ� ���� (�����ּ� ������ �������� ���� ��� + ������ ���)
		System.out.println(socket2.getLocalAddress()+":"+socket2.getLocalPort());
		System.out.println(socket2.getLocalSocketAddress());
		System.out.println(socket3.getLocalAddress()+":"+socket3.getLocalPort());
		System.out.println(socket3.getLocalSocketAddress());
		System.out.println();
		
		//@send/receive ���� ������
		try {
			System.out.println(socket2.getSendBufferSize() + ", "+ socket2.getReceiveBufferSize()); //65536, 65536
		} catch (SocketException e) {}
			
	}
}
