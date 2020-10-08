package pack02_javaio.sec02_FileInputOutputStream.EX03_FileInputStream_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/*FileInputStream의 read(.) 메서드를 이용한 데이터 읽기 (한글파일 읽기)*/

public class EX03_FileInputStream_3 {
	public static void main(String[] args) throws IOException {
		//입력파일 생성
		File inFile = new File("src/pack02_javaio/sec02_files/FileInputStream2.txt ");
				
		//#2-2. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장) 
		byte[] byteArray1 = new byte[8];
		InputStream is2 = new FileInputStream(inFile);
		int count1;
		while((count1 = is2.read(byteArray1))!=-1) { 
			
			String str = new String(byteArray1, 0, count1, Charset.forName("MS949"));
			System.out.print(str);
			System.out.println(" : count="+count1);

		}
		System.out.println();

		
		//#3-2. n-byte 단위 입력 (length만큼의 길이를 읽어와 byte[]의 offset 위치에서 부터 저장) 
		byte[] byteArray2 = new byte[8];
		InputStream is3 = new FileInputStream(inFile);
		int offset=2; int length=6;
		int count2 = is3.read(byteArray2, offset, length);//offset:2 length:6		
		
		//String str = new String(byteArray2, 0, offset+count2, Charset.defaultCharset());
		String str = new String(byteArray2, offset, count2, Charset.forName("MS949")); //안녕하
		System.out.println(str);
		
		//#InputStream 자원 반납
		is2.close();
		is3.close();
		
		//System.out.println(new String(byteArray2, 0, offset+count2, Charset.defaultCharset()));

	}
}
