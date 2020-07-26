package pack03_javaio.sec04_FilterInputOutputStream.EX02_DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*Data(Input/Output)Stream Ŭ������ Ȱ���� �پ��� Ÿ���� ����� ����*/

public class EX02_DataInputOutputStream {
	public static void main(String[] args) throws IOException {
		//���� ����
		File dataFile = new File("src/pack03_javaio/sec04_files/file1.data");
		if(!dataFile.exists()) dataFile.createNewFile();

		//������ ���� (FilterStream = DataOutputStream)
		try(OutputStream os = new FileOutputStream(dataFile);
		    DataOutputStream dos = new DataOutputStream(os);) {
			
			dos.writeInt(35);
		    dos.writeDouble(5.8);
		    dos.writeChar('A');
		    dos.writeUTF("�ȳ��ϼ���");
		    dos.flush();

		}catch(IOException e) {}
		
		
		//������ �б� (FilterStream = DataInputStream)
		try(InputStream is = new FileInputStream(dataFile);
		    DataInputStream dis = new DataInputStream(is);){

		        System.out.println(dis.readInt()); //->35
		        System.out.println(dis.readDouble()); //->5.8
		        System.out.println(dis.readChar()); //->A
		        System.out.println(dis.readUTF()); //->�ȳ��ϼ���

		}catch(IOException e) {}

	}
}
