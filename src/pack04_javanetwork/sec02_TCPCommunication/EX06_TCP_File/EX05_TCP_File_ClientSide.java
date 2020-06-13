package pack04_javanetwork.sec02_TCPCommunication.EX06_TCP_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EX05_TCP_File_ClientSide {
	public static void main(String[] args) {
		System.out.println("<<Client>>");
		Socket socket=null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),10000);
			System.out.println("Server俊 立加肯丰");
			System.out.println("立加 server 林家:"+socket.getInetAddress()+":"+socket.getPort());
			
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
						
			File file = new File("files/sendImageUsingTCP.jpg");			
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			System.out.println("颇老傈价: "+file.getName());
			dos.writeUTF(file.getName());
			
			byte[] data = new byte[2048];
			int len;
			while((len = bis.read(data))!=-1) {
				dos.writeInt(len);
				dos.write(data,0,len);
				dos.flush();
			}
			dos.writeInt(-1);
			dos.flush();
			
			String str = dis.readUTF();			
			System.out.println(str);
			
		} 
		catch (UnknownHostException e) {}
		catch (IOException e) {}
	}
}