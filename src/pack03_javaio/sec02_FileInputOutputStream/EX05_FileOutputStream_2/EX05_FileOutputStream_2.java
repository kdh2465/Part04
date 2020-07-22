package pack03_javaio.sec02_FileInputOutputStream.EX05_FileOutputStream_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class EX05_FileOutputStream_2 {
	public static void main(String[] args) throws IOException {
		
		//입력파일 생성
		File outFile = new File("src/pack03_javaio/sec02_files/FileOutputStream2.txt");
		if(!outFile.exists()) outFile.createNewFile();
		
		//#2-2. n-byte 단위 쓰기 (byte[]의 처음 위치에서 부터 끝가지를 출력) 
		byte[] byteArray1 = "안녕하세요".getBytes(Charset.forName("MS949"));
		OutputStream os2 = new FileOutputStream(outFile, false);//내용 연결
		os2.write(byteArray1);
		os2.write('\n');
		
		os2.flush();
		os2.close();
		
		//#3-2. n-byte 단위 쓰기 (byte[]의 offset 위치에서부터 length개수를 읽어와 출력) 
		byte[] byteArray2 = "반갑습니다.".getBytes(Charset.defaultCharset());
		OutputStream os3 = new FileOutputStream(outFile, true); //내용 연결
		os3.write(byteArray2, 2, 4);

		os3.flush();
		os3.close();
		
	}
}
