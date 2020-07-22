package pack03_javaio.sec01_FileAndCharset.EX03_Charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*�ڹ��� ���ڼ� (EUC-KR vs. MS949, UTF-16 vs. UTF-8, Charset ��ü ����)*/

public class EX03_Charset {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1. EUC-KR vs. MS949
		System.out.println(new String("�v".getBytes("EUC-KR")));
		System.out.println(new String("�v".getBytes("MS949")));
		
		//#2. UTF-16 vs. UTF-8
		System.out.println(new String("abc".getBytes("UTF-16"))); //UTF-16�� BOM(Byte Order Mark,0xFE Little Endian, 0x00 Big Endian) 1byte ����
		System.out.println(new String("abc".getBytes("UTF-8")));
		
		//#3-1. Charset ��ü ����
		Charset cs1 = Charset.defaultCharset(); //x-windows-949		
		Charset cs2 = Charset.forName("MS949");
		Charset cs3 = Charset.forName("UTF-8");
				
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs3);
		
		//#3-2. JVM ���ڼ� ��������
		System.out.println(Charset.isSupported("MS949"));
		System.out.println(Charset.isSupported("UTF-8"));
		
	}
}
