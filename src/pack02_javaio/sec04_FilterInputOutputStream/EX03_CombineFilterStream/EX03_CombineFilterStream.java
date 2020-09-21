package pack02_javaio.sec04_FilterInputOutputStream.EX03_CombineFilterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*Buffered(Input/Output)Stream과 Data(Input/Output)Stream의 조합*/

public class EX03_CombineFilterStream {
	public static void main(String[] args) throws IOException {
		//파일 생성
		File dataFile = new File("src/pack03_javaio/sec04_files/file2.data");
		if(!dataFile.exists()) dataFile.createNewFile();

		//데이터 쓰기 (FilterStream = BufferedOutputStream + DataOutputStream)
		try(OutputStream os = new FileOutputStream(dataFile);
		     BufferedOutputStream bos = new BufferedOutputStream(os);
		     DataOutputStream dos = new DataOutputStream(bos);) {

		        dos.writeInt(35);
		        dos.writeDouble(5.8);
		        dos.writeChar('A');
		        
		        dos.writeUTF("안녕하세요");
		        dos.flush();

		}catch(IOException e) {}
		
		
		//데이터 읽기 (FilterStream = BufferedInputStream + DataInputStream)
		try(InputStream is = new FileInputStream(dataFile);
		    BufferedInputStream bis = new BufferedInputStream(is);
		    DataInputStream dis = new DataInputStream(bis);){

		        System.out.println(dis.readInt()); //->35
		        System.out.println(dis.readDouble()); //->5.8
		        System.out.println(dis.readChar()); //->A
		        System.out.println(dis.readUTF()); //->안녕하세요

		}catch(IOException e) {}
		
	}
}
