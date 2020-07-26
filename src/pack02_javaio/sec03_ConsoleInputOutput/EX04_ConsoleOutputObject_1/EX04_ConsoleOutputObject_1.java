package pack02_javaio.sec03_ConsoleInputOutput.EX04_ConsoleOutputObject_1;

import java.io.IOException;
import java.io.OutputStream;

/*write(.) 메서드를 이용한 콘솔(Console)로 데이터 출력하기(영문데이터 출력)*/

public class EX04_ConsoleOutputObject_1 {
	public static void main(String[] args) throws IOException {

		//# OutputStream 생성(콘솔)
		OutputStream os = System.out;

		//#1. 1-byte 단위 쓰기		
		os.write('J');
		os.write('A');
		os.write('V');
		os.write('A');
		os.write(13); //carriage return 
		os.write(10); //line feed

		os.flush();
		
		//#2-1. n-byte 단위 쓰기 (byte[]의 처음 위치에서 부터 끝가지를 출력) 
		byte[] byteArray1 = "Hello!".getBytes();
		os.write(byteArray1);
		os.write('\n');
		os.flush();

		//#3-1. n-byte 단위 쓰기 (byte[]의 offset 위치에서부터 length개수를 읽어와 출력) 
		byte[] byteArray2 = "Better the last smile than the first laughter.".getBytes();
		os.write(byteArray2, 7, 8);
		os.flush();
		
	}
}
