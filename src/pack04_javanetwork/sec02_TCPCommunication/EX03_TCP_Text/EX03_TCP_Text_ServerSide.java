package pack04_javanetwork.sec02_TCPCommunication.EX05_TCP_Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EX05_TCP_Text_ServerSide {
	public static void main(String[] args) {
		System.out.print("<<Server>>");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			System.out.println("�ش���Ʈ�� ����� �� �����ϴ�.");
			System.exit(0);
		}
		
		System.out.println(" - Client ���� ���...");
		try {
			Socket socket = serverSocket.accept();

			System.out.println("Client ���� ����");
			System.out.println("���� client �ּ�:"+socket.getInetAddress()+":"+socket.getPort());
				
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			String str=dis.readUTF();
			System.out.println("client: " + str);			
			dos.writeUTF("�������!");
			dos.flush();
			
		} catch (IOException e) {}
		
	}
}