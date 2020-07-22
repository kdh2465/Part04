package pack03_javaio.sec01_FileAndCharset.EX03_Charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*자바의 문자셋 (EUC-KR vs. MS949, UTF-16 vs. UTF-8, Charset 객체 생성)*/

public class EX03_Charset {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1. EUC-KR vs. MS949
		System.out.println(new String("봵".getBytes("EUC-KR")));
		System.out.println(new String("봵".getBytes("MS949")));
		
		//#2. UTF-16 vs. UTF-8
		System.out.println(new String("abc".getBytes("UTF-16"))); //UTF-16은 BOM(Byte Order Mark,0xFE Little Endian, 0x00 Big Endian) 1byte 포함
		System.out.println(new String("abc".getBytes("UTF-8")));
		
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
