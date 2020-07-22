package pack03_javaio.sec02_FileInputOutputStream.EX06_FileInputStream_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EX06_FileInputStream_2 {
	public static void main(String[] args) throws IOException {
		//�Է����� ����
		File inFile = new File("src/pack03_javaio/sec02_files/FileInputStream1.txt ");

		//#1. 1-byte ���� �б�
		InputStream is1 = new FileInputStream(inFile);
		int data;
		while((data=is1.read())!= -1 ) { 
		  System.out.print((char)data);
		}
		System.out.println(); System.out.println();
		
		
		//#2-1. n-byte ���� �б� (byte[]�� ó�� ��ġ���� ���� ���� ������ ����) 
		byte[] byteArray1 = new byte[9];
		InputStream is2 = new FileInputStream(inFile);
		int count1;
		while((count1 = is2.read(byteArray1))!=-1) { 
			for(int i=0; i<count1; i++)
				System.out.print((char)byteArray1[i]);
			System.out.println(" : count="+count1);
		}
		System.out.println(); System.out.println();

		
		//#3-1. n-byte ���� �Է� (length��ŭ�� ���̸� �о�� byte[]�� offset ��ġ���� ���� ����) 
		byte[] byteArray2 = new byte[9];
		InputStream is3 = new FileInputStream(inFile);
		int offset=3; int length=6;
		int count2 = is3.read(byteArray2, offset, length);//offset:3 length:6		
		for(int i=0; i<offset+count2; i++)
			System.out.print((char)byteArray2[i]);		
		
		//#InputStream �ڿ� �ݳ�
		is1.close();
		is2.close();
		is3.close();
				
	}
}
