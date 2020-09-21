package pack02_javaio.sec01_FileAndCharset.EX02_FileMethods;

import java.io.File;

/*파일 클래스의 주요 메서드*/

public class EX02_FileMethods {
	public static void main(String[] args) {
		//#. C 드라이브내에 temp 폴더가 없는 경우 생성
		File tempDir = new File("C:/temp");
		if(!tempDir.exists()) tempDir.mkdir();
		
		//#. 파일객체 생성
		File file = new File("C:/Windows");
		
		//#. 파일 메서드 
		System.out.println("절대경로: "+file.getAbsolutePath());
		System.out.println("폴더(?): "+file.isDirectory());
		System.out.println("파일(?): "+file.isFile());
		System.out.println("파일이름: "+file.getName()); //또는 폴더이름
		System.out.println("부모폴더: "+file.getParent());
		
		File newfile1 = new File("C:/temp/abc");
		System.out.println(newfile1.mkdir()); //true		
		File newfile2 = new File("C:/temp/bcd/cde");
		System.out.println(newfile2.mkdir()); //false
		System.out.println(newfile2.mkdirs()); //true

				
		File[] fnames = file.listFiles();
		for(File fname : fnames)
			System.out.println((fname.isDirectory()?"폴더: ":"파일: ")+fname.getName());
		
	}
}
