package pack03_javaio.sec02_FileInputOutputStream.EX05_FileInputStream_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class EX05_FileInputStream_1 {
	public static void main(String[] args) throws IOException {
		//�Է����� ����
		File inFile = new File("sec02.files/FileInputStream1.txt");

		//InputStream ���� 
		InputStream is = new FileInputStream(inFile);
		int data;
		while((data=is.read())!=-1) {
		  System.out.println("���� ������ : "+ (char)data + " ���� ����Ʈ��: "+ is.available());
		}

		//InputStream �ڿ��ݳ�
		is.close();

	}
}