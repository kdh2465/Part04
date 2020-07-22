package pack03_javaio.sec02_FileInputOutputStream.EX05_FileOutputStream_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class EX05_FileOutputStream_2 {
	public static void main(String[] args) throws IOException {
		
		//�Է����� ����
		File outFile = new File("src/pack03_javaio/sec02_files/FileOutputStream2.txt");
		if(!outFile.exists()) outFile.createNewFile();
		
		//#2-2. n-byte ���� ���� (byte[]�� ó�� ��ġ���� ���� �������� ���) 
		byte[] byteArray1 = "�ȳ��ϼ���".getBytes(Charset.forName("MS949"));
		OutputStream os2 = new FileOutputStream(outFile, false);//���� ����
		os2.write(byteArray1);
		os2.write('\n');
		
		os2.flush();
		os2.close();
		
		//#3-2. n-byte ���� ���� (byte[]�� offset ��ġ�������� length������ �о�� ���) 
		byte[] byteArray2 = "�ݰ����ϴ�.".getBytes(Charset.defaultCharset());
		OutputStream os3 = new FileOutputStream(outFile, true); //���� ����
		os3.write(byteArray2, 2, 4);

		os3.flush();
		os3.close();
		
	}
}
