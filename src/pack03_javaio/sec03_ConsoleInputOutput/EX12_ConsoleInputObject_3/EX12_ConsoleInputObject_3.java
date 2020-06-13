package pack03_javaio.sec03_ConsoleInputOutput.EX12_ConsoleInputObject_3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class EX12_ConsoleInputObject_3 {
	public static void main(String[] args) throws IOException {
		
		//InputStream 객체 생성
		InputStream is = System.in;

		//#2-2. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장)
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1);
		
		String str1 = new String(byteArray1,0,count1, Charset.forName("MS949"));
		System.out.println(str1);

		//#3-1. n-byte 단위 입력 (length만큼의 길이를 읽어와 byte[]의 offset 위치에서 부터 저장)
		int offset=2;
		int length=4;
		byte[] byteArray2 = new byte[100];		
		int count2 = is.read(byteArray2, offset, length);//offset:3 length:5
		String str2 = new String(byteArray2,0,offset+count2, Charset.defaultCharset());
		System.out.println(str2);

	}
}
