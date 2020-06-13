package pack04_javanetwork.sec02_TCPCommunication.EX05_TCP_Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EX05_TCP_Text_ClientSide {
	public static void main(String[] args) {
		System.out.println("<<Client>>");
		Socket socket=null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),10000);
			System.out.println("Server俊 立加肯丰");
			System.out.println("立加 server 林家:"+socket.getInetAddress()+":"+socket.getPort());
			
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			dos.writeUTF("救崇窍技夸");
			dos.flush();
			String str=dis.readUTF();
			System.out.println("server: "+str);			
		} 
		catch (UnknownHostException e) {}
		catch (IOException e) {}
	}
}