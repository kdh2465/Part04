package pack02_javaio.sec02_FileInputOutputStream.EX04_FileOutputStream_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*FileOutputStream�� write(.) �޼��带 �̿��� ������ ���� (�������� ����)*/

public class EX04_FileOutputStream_1 {
	public static void main(String[] args) throws IOException {
				
		//�Է����� ����
		File outFile = new File("src/pack03_javaio/sec02_files/FileOutputStream1.txt");
		if(!outFile.exists()) outFile.createNewFile(); //������ ���� ��쿡�� �������� (�ڵ� ����)
		
		//#1. 1-byte ���� ����		
		OutputStream os1 = new FileOutputStream(outFile);
		os1.write('J');
		os1.write('A');
		os1.write('V');
		os1.write('A');
		os1.write('\r'); //13
		os1.write('\n'); //10
		
		os1.flush();
		os1.close();
		
		//#2. n-byte ���� ���� (byte[]�� ó�� ��ġ���� ���� �������� ���) 
		byte[] byteArray1 = "Hello!".getBytes();
		OutputStream os2 = new FileOutputStream(outFile, true);//���� ����
		os2.write(byteArray1);
		os2.write('\n');
		
		os2.flush();
		os2.close();
		
		//#3. n-byte ���� ���� (byte[]�� offset ��ġ�������� length������ �о�� ���) 
		byte[] byteArray2 = "Better the last smile than the first laughter.".getBytes();
		OutputStream os3 = new FileOutputStream(outFile, true); //���� ����
		os3.write(byteArray2, 7, 8);

		os3.flush();
		os3.close();
		
	}
}
