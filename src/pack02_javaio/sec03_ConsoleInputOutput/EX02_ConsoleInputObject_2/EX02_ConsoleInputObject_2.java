package pack02_javaio.sec03_ConsoleInputOutput.EX02_ConsoleInputObject_2;

import java.io.IOException;
import java.io.InputStream;

/*read(.) 메서드를 이용한 콘솔(Console)로 부터 데이터 읽기 (영문입력 읽기)*/

public class EX02_ConsoleInputObject_2 {
	public static void main(String[] args) throws IOException {
		
		//InputStream 객체 생성
		InputStream is = System.in;

		//#1. 1-byte 단위 읽기
		int data;
		while((data=is.read())!='\r') {  
		  System.out.print((char)data);
		}
		is.read(); //'\n';
		System.out.println();
		System.out.println();
	
		//#2-1. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장)
		byte[] byteArray1 = new byte[100];
		int count1 = is.read(byteArray1);

		for (int i = 0; i < count1; i++)
			System.out.print((char) byteArray1[i]);
		System.out.println(" : count=" + count1);

		System.out.println();
		
		//#3-1. n-byte 단위 입력 (length만큼의 길이를 읽어와 byte[]의 offset 위치에서 부터 저장)
		byte[] byteArray2 = new byte[100];
		int offset=3;
		int length=5;
		int count2 = is.read(byteArray2, offset, length);//offset:3 length:5
		for (int i = 0; i < offset+count2; i++)
			System.out.print((char) byteArray2[i]);
		System.out.println(" : count=" + count2);

	}
}
