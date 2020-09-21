package pack03_javanetwork.sec02_TCPCommunication.EX03_TCP_Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*TCP 통신예제 1 : 클라이언트와 서버간의 텍스트(text) 전송 [ServerSide]*/

public class EX03_TCP_Text_ServerSide {
	public static void main(String[] args) {
		System.out.println("<<Server>>");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			System.out.println("해당포트를 사용할 수 없습니다.");
			System.exit(0);
		}
		
		System.out.println("Client 접속 대기...");
		try {
			Socket socket = serverSocket.accept();

			System.out.println("Client 연결 수락");
			System.out.println("접속 client 주소:"+socket.getInetAddress()+":"+socket.getPort());
				
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			String str=dis.readUTF();
			System.out.println("client: " + str);			
			dos.writeUTF("어서오세요!");
			dos.flush();
			
		} catch (IOException e) {}
		
	}
}
