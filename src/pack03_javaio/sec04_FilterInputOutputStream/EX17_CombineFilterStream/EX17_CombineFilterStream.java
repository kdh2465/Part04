package pack03_javaio.sec04_FilterInputOutputStream.EX17_CombineFilterStream;

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

public class EX17_CombineFilterStream {
	public static void main(String[] args) throws IOException {
		//���� ����
		File dataFile = new File("sec04.files/file.data");
		if(!dataFile.exists()) dataFile.createNewFile();

		//������ ���� (FilterStream = BufferedOutputStream + DataOutputStream)
		try(OutputStream os = new FileOutputStream(dataFile);
		     BufferedOutputStream bos = new BufferedOutputStream(os);
		     DataOutputStream dos = new DataOutputStream(bos);) {

		        dos.writeInt(35);
		        dos.writeDouble(5.8);
		        dos.writeChar('A');
		        dos.writeUTF("�ȳ��ϼ���");
		        dos.flush();

		}catch(IOException e) {}
		
		
		//������ �б� (FilterStream = BufferedInputStream + DataInputStream)
		try(InputStream is = new FileInputStream(dataFile);
		    BufferedInputStream bis = new BufferedInputStream(is);
		    DataInputStream dis = new DataInputStream(bis);){

		        System.out.println(dis.readInt()); //->35
		        System.out.println(dis.readDouble()); //->5.8
		        System.out.println(dis.readChar()); //->A
		        System.out.println(dis.readUTF()); //->�ȳ��ϼ���

		}catch(IOException e) {}
		
	}
}
