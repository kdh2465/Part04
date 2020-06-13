package pack03_javaio.sec03_ConsoleInputOutput.EX12_ConsoleInputObject_3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class EX12_ConsoleInputObject_3 {
	public static void main(String[] args) throws IOException {
		
		//InputStream ��ü ����
		InputStream is = System.in;

		//#2-2. n-byte ���� �б� (byte[]�� ó�� ��ġ���� ���� ���� ������ ����)
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1);
		
		String str1 = new String(byteArray1,0,count1, Charset.forName("MS949"));
		System.out.println(str1);

		//#3-1. n-byte ���� �Է� (length��ŭ�� ���̸� �о�� byte[]�� offset ��ġ���� ���� ����)
		int offset=2;
		int length=4;
		byte[] byteArray2 = new byte[100];		
		int count2 = is.read(byteArray2, offset, length);//offset:3 length:5
		String str2 = new String(byteArray2,0,offset+count2, Charset.defaultCharset());
		System.out.println(str2);

	}
}
