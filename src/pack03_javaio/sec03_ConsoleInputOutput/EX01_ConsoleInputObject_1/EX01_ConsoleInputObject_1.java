package pack03_javaio.sec03_ConsoleInputOutput.EX01_ConsoleInputObject_1;

import java.io.IOException;
import java.io.InputStream;

public class EX01_ConsoleInputObject_1 {
	public static void main(String[] args) throws IOException {
		//InputStream ���� 
		InputStream is = System.in;
		int data;
		while((data=is.read())!='\r') {
		  System.out.println("���� ������ : "+ (char)data + " ���� ����Ʈ��: "+ is.available());
		}
		System.out.println(data); //\r(13)
		System.out.println(is.read()); //\n(10)

		//InputStream �ڿ��ݳ�
		is.close();
	}
}
