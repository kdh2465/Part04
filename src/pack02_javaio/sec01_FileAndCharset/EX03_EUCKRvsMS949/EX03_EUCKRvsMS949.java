package pack02_javaio.sec01_FileAndCharset.EX03_EUCKRvsMS949;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/*자바의 문자셋 (EUC-KR vs. MS949)*/

public class EX03_EUCKRvsMS949 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1. EUC-KR vs. MS949
		byte[] b1 = "a".getBytes("EUC-KR");
		byte[] b2 = "a".getBytes("MS949");
		
		System.out.println(b1.length);
		System.out.println(b2.length);
		
		System.out.println(new String(b1, "EUC-KR"));
		System.out.println(new String(b2, "MS949"));
		System.out.println();
		
		
		byte[] b3 = "가".getBytes("EUC-KR");
		byte[] b4 = "가".getBytes("MS949");
		
		System.out.println(b3.length);
		System.out.println(b4.length);
		
		System.out.println(new String(b3, "EUC-KR"));
		System.out.println(new String(b4, "MS949"));
		System.out.println();
		
		
		byte[] b5 = "봵".getBytes("EUC-KR");
		byte[] b6 = "봵".getBytes("MS949");
		
		System.out.println(b5.length);
		System.out.println(b6.length);
		
		System.out.println(new String(b5, "EUC-KR"));
		System.out.println(new String(b6, "MS949"));
		System.out.println();
						
	}
}
