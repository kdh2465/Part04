package pack03_javaio.sec01_FileAndCharset.EX01_CreateFileObject;

import java.io.File;
import java.io.IOException;

public class EX01_CreateFileObject {
	public static void main(String[] args) throws IOException {
		
		//#1-0. C ����̺곻�� temp ������ ���� ��� ����
		File tempDir = new File("C:/temp");
		if(!tempDir.exists()) tempDir.mkdir();
		
		//#1-1. ���ϰ�ü ����
		File newFile = new File("C:/temp/newFile.txt");
		//#1-2. ������ ���� ��� ���� ���� ����
		if(!newFile.exists()) newFile.createNewFile(); //temp ������ ���� ��� ���� �߻�
		
		//#2. ���� ������
		File newFile2 = new File("C:\\temp\\newFile.txt");
		File newFile3 = new File("C:"+File.separator+"temp"+File.separator+"newFile.txt");
		File newFile4 = new File("C:/temp/newFile.txt");
		System.out.println(newFile2.exists());
		System.out.println(newFile3.exists());
		System.out.println(newFile4.exists());
		
		//#3-1. ������
		File newFile5 = new File("C:/abc/newFile.txt");
		File newFile6 = new File("C:/abc/bcd/newFile.txt");
		System.out.println(newFile5.getAbsolutePath());	
		System.out.println(newFile6.getAbsolutePath());	
		
		//#3-2. �����
		System.out.println(System.getProperty("user.dir")); //���� �۾� ��ġ
		File newFile7 = new File("newFile1.txt");
		File newFile8 = new File("bcd/newFile2.txt");
		System.out.println(newFile7.getAbsolutePath());
		System.out.println(newFile8.getAbsolutePath());	

	}
}
