package pack03_javaio.sec01_FileAndCharset.EX02_FileMethods;

import java.io.File;

public class EX02_FileMethods {
	public static void main(String[] args) {
		
		//#. ���ϰ�ü ����
		File file = new File("C:/Windows");
		
		//#. ���� �޼��� 
		System.out.println("������: "+file.getAbsolutePath());
		System.out.println("����(?): "+file.isDirectory());
		System.out.println("����(?): "+file.isFile());
		System.out.println("�����̸�: "+file.getName());
		System.out.println("�θ�����: "+file.getParent());
		
		File newfile1 = new File("C:/temp/abc");
		System.out.println(newfile1.mkdir()); //true		
		File newfile2 = new File("C:/temp/bcd/cde");
		System.out.println(newfile2.mkdir()); //false
		System.out.println(newfile2.mkdirs()); //true
				
		File[] fnames = file.listFiles();
		for(File fname : fnames)
			System.out.println((fname.isDirectory()?"����: ":"����: ")+fname.getName());
		
	}
}
