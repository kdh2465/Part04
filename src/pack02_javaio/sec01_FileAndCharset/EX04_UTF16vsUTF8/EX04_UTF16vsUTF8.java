package pack02_javaio.sec01_FileAndCharset.EX04_UTF16vsUTF8;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/*자바의 문자셋 (UTF-16 vs. UTF-8, Charset 객체 생성)*/

public class EX04_UTF16vsUTF8 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1. UTF-16 vs. UTF-8
		byte[] b1 = "abc".getBytes("UTF-16");
		byte[] b2 = "abc".getBytes("UTF-8");
				
		System.out.println(b1.length); //8
		System.out.println(b2.length); //3
		
		for(byte b : b1)
			System.out.printf("%02X ", b);
		System.out.println();
		
		for(byte b : b2)
			System.out.printf("%02X ", b);
		System.out.println();
		
		System.out.println(new String(b1, "UTF-16"));
		System.out.println(new String(b2, "UTF-8"));
		System.out.println();
		
		byte[] b3 = "가나다".getBytes("UTF-16");
		byte[] b4 = "가나다".getBytes("UTF-8");
		
		System.out.println(b3.length); 
		System.out.println(b4.length);
		
		for(byte b : b3)
			System.out.printf("%02X ", b);
		System.out.println();
		
		for(byte b : b4)
			System.out.printf("%02X ", b);
		System.out.println();
		
		System.out.println(new String(b3, "UTF-16"));
		System.out.println(new String(b4, "UTF-8"));
		System.out.println();
		
				
		//#3-1. Charset 객체 생성
		Charset cs1 = Charset.defaultCharset(); //x-windows-949		
		Charset cs2 = Charset.forName("MS949");
		Charset cs3 = Charset.forName("UTF-8");
				
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs3);
		
		//#3-2. JVM 문자셋 지원여부
		System.out.println(Charset.isSupported("MS949"));
		System.out.println(Charset.isSupported("UTF-8"));
		
	}
}
