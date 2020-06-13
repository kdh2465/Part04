package pack03_javaio.sec03_ConsoleInputOutput.EX11_ConsoleInputObject_2;

import java.io.IOException;
import java.io.InputStream;

public class EX11_ConsoleInputObject_2 {
	public static void main(String[] args) throws IOException {
		
		//InputStream ��ü ����
		InputStream is = System.in;

		//#1. 1-byte ���� �б�
		int data;
		while((data=is.read())!='\r') {  
		  System.out.print((char)data);
		}
		is.read(); //'\n';
		System.out.println();
		System.out.println();
	
		//#2-1. n-byte ���� �б� (byte[]�� ó�� ��ġ���� ���� ���� ������ ����)
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1);

		for (int i = 0; i < count1; i++)
			System.out.print((char) byteArray1[i]);
		System.out.println(" : count=" + count1);

		System.out.println();
		
		//#3-1. n-byte ���� �Է� (length��ŭ�� ���̸� �о�� byte[]�� offset ��ġ���� ���� ����)
		byte[] byteArray2 = new byte[100];
		int offset=3;
		int length=5;
		int count2 = is.read(byteArray2, offset, length);//offset:3 length:5
		for (int i = 0; i < offset+count2; i++)
			System.out.print((char) byteArray2[i]);
		System.out.println(" : count=" + count2);

	}
}
