package pack03_javaio.sec02_FileInputOutputStream.EX07_FileInputStream_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class EX07_FileInputStream_3 {
	public static void main(String[] args) throws IOException {
		//�Է����� ����
		File inFile = new File("sec02.files/FileInputStream2.txt ");
		
		
		//#2-2. n-byte ���� �б� (byte[]�� ó�� ��ġ���� ���� ���� ������ ����) 
		byte[] byteArray1 = new byte[8];
		InputStream is2 = new FileInputStream(inFile);
		int count1;
		while((count1 = is2.read(byteArray1))!=-1) { 
			
			String str = new String(byteArray1, 0, count1, Charset.forName("MS949"));
			System.out.print(str);
			System.out.println(" : count="+count1);

		}
		System.out.println();

		
		//#3-2. n-byte ���� �Է� (length��ŭ�� ���̸� �о�� byte[]�� offset ��ġ���� ���� ����) 
		byte[] byteArray2 = new byte[8];
		InputStream is3 = new FileInputStream(inFile);
		int offset=2; int length=6;
		int count2 = is3.read(byteArray2, offset, length);//offset:2 length:6		
		
		String str = new String(byteArray2, 0, offset+count2, Charset.defaultCharset());
		System.out.println(str);
		
		//#InputStream �ڿ� �ݳ�
		is2.close();
		is3.close();
		
		//System.out.println(new String(byteArray2, 0, offset+count2, Charset.defaultCharset()));

	}
}
