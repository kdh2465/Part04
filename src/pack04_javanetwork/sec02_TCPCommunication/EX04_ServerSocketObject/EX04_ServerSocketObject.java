package pack04_javanetwork.sec02_TCPCommunication.EX04_ServerSocketObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EX04_ServerSocketObject {
	public static void main(String[] args) {
		
		//#1. ServerSocket ��ü ����
		ServerSocket serverSocket1 = null;
		ServerSocket serverSocket2 = null;

		try {
			serverSocket1 = new ServerSocket();
			serverSocket2 = new ServerSocket(20000);

		} catch (IOException e) {}		
		
		
		//#2. ServerSocket �޼���		
		//@bind
		System.out.println(serverSocket1.isBound());//false
		System.out.println(serverSocket2.isBound());//true
		
		try {
			serverSocket1.bind(new InetSocketAddress("127.0.0.1", 10000));
		} catch (IOException e) {}
		
		System.out.println(serverSocket1.isBound());//true
		System.out.println(serverSocket2.isBound());//true
		
		System.out.println();
		//@ ������� TCP ��Ʈ Ȯ���ϱ� (cmd: netstat -a)
		for(int i=0; i<65536; i++) {
			try {
				ServerSocket serverSocket = new ServerSocket(i);
			} catch (IOException e) {
				System.err.println(i+"��° ��Ʈ ����� ...");
			} 
		}
		System.out.println();
		
		//@ accept() / setSoTimeout() / getSoTimeout() 
		//Client�� ���� TCP ���� ��� (�Ϲ������� ������ ���)				
		try {
			serverSocket1.setSoTimeout(2000);
		} catch (SocketException e) {e.printStackTrace();}
		
		try {
			Socket socket = serverSocket1.accept();			
		} catch (IOException e) {
			try {
				System.out.println(serverSocket1.getSoTimeout() + "ms �ð��� ���� listening�� ����");
			} catch (IOException e1) {}
		}		
		
	}
}
