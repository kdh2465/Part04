package pack02_javaio.sec03_ConsoleInputOutput.EX05_ConsoleOutputObject_2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/*write(.) 메서드를 이용한 콘솔(Console)로 데이터 출력하기(한글데이터 출력)*/

public class EX05_ConsoleOutputObject_2 {
	public static void main(String[] args) throws IOException {

		//# OutputStream 생성(콘솔)
		OutputStream os = System.out;

		//#2-2. n-byte 단위 쓰기 (byte[]의 처음 위치에서 부터 끝가지를 출력) 
		byte[] byteArray1 = "안녕하세요".getBytes(Charset.forName("MS949"));
		os.write(byteArray1);
		os.write('\n');
		os.flush();

		//#3-2. n-byte 단위 쓰기 (byte[]의 offset 위치에서부터 length개수를 읽어와 출력) 
		byte[] byteArray2 = "반갑습니다".getBytes(Charset.defaultCharset());
		os.write(byteArray2, 4, 4);
		os.flush();
		
	}
}
