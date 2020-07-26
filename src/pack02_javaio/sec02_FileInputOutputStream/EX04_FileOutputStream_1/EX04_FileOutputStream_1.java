package pack02_javaio.sec02_FileInputOutputStream.EX04_FileOutputStream_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*FileOutputStream의 write(.) 메서드를 이용한 데이터 쓰기 (영문파일 쓰기)*/

public class EX04_FileOutputStream_1 {
	public static void main(String[] args) throws IOException {
				
		//입력파일 생성
		File outFile = new File("src/pack03_javaio/sec02_files/FileOutputStream1.txt");
		if(!outFile.exists()) outFile.createNewFile(); //파일을 쓰는 경우에는 생략가능 (자동 생성)
		
		//#1. 1-byte 단위 쓰기		
		OutputStream os1 = new FileOutputStream(outFile);
		os1.write('J');
		os1.write('A');
		os1.write('V');
		os1.write('A');
		os1.write('\r'); //13
		os1.write('\n'); //10
		
		os1.flush();
		os1.close();
		
		//#2. n-byte 단위 쓰기 (byte[]의 처음 위치에서 부터 끝가지를 출력) 
		byte[] byteArray1 = "Hello!".getBytes();
		OutputStream os2 = new FileOutputStream(outFile, true);//내용 연결
		os2.write(byteArray1);
		os2.write('\n');
		
		os2.flush();
		os2.close();
		
		//#3. n-byte 단위 쓰기 (byte[]의 offset 위치에서부터 length개수를 읽어와 출력) 
		byte[] byteArray2 = "Better the last smile than the first laughter.".getBytes();
		OutputStream os3 = new FileOutputStream(outFile, true); //내용 연결
		os3.write(byteArray2, 7, 8);

		os3.flush();
		os3.close();
		
	}
}
