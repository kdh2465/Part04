package pack04_javanetwork.sec02_TCPCommunication.EX04_TCP_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EX04_TCP_File_ServerSide {
	public static void main(String[] args) {
		System.out.print("<<Server>>");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			System.out.println("해당포트를 사용할 수 없습니다.");
			System.exit(0);
		}
		
		System.out.println(" - Client 접속 대기...");
		try {
			Socket socket = serverSocket.accept();

			System.out.println("Client 연결 수락");
			System.out.println("접속 client 주소:"+socket.getInetAddress()+":"+socket.getPort());
				
			DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			File file = new File("src/pack04_javanetwork/common_files/receivedImageUsingTCP.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
						
			String str=dis.readUTF();
			System.out.println("파일수신: "+str + "\n파일저장: " + file.getName());
			
			byte[] data = new byte[2048];
			int len;
			while((len=dis.readInt())!=-1) {
				dis.read(data,0,len);
				bos.write(data,0,len);	
				bos.flush();
			}						
			System.out.println("파일 수신 완료");
			dos.writeUTF("파일 전송 완료");
			dos.flush();
			
		} catch (IOException e) {}
		
	}
}
