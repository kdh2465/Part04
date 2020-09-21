package pack03_javanetwork.sec02_TCPCommunication.EX04_TCP_File;

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

/*TCP 통신예제 2 : 클라이언트와 서버간의 파일(file) 전송 [ClientSide]*/

public class EX04_TCP_File_ClientSide {
	public static void main(String[] args) {
		System.out.println("<<Client>>");
		Socket socket=null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),10000);
			System.out.println("Server에 접속완료");
			System.out.println("접속 server 주소:"+socket.getInetAddress()+":"+socket.getPort());
			
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
						
			File file = new File("src/pack04_javanetwork/common_files/sendImageUsingTCP.jpg");			
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			System.out.println("파일전송: "+file.getName());
			dos.writeUTF(file.getName()); //파일이름전송
			
			byte[] data = new byte[2048];
			int len;
			while((len = bis.read(data))!=-1) {
				dos.writeInt(len); //전송데이터의 길이
				dos.write(data,0,len); //전송데이터
				dos.flush();
			}
			dos.writeInt(-1); //데이터 전송완료 알림
			dos.flush();
			
			String str = dis.readUTF();			
			System.out.println(str);
			
		} 
		catch (UnknownHostException e) {}
		catch (IOException e) {}
	}
}