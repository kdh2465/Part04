package pack03_javaio.sec01_FileAndCharset.EX04_ByteArrayToFromString;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class EX04_ByteArrayToFromString {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1-1. String�� getBytes()�� �̿��� byte[] --> ���ڿ�
		byte[] array1 = "�ȳ�".getBytes();
		byte[] array2 = "��ť".getBytes(Charset.defaultCharset());
		byte[] array3 = "����".getBytes(Charset.forName("MS949"));
		byte[] array4 = "����".getBytes("UTF-8");
		
		System.out.println(array1.length); //4
		System.out.println(array2.length); //4
		System.out.println(array3.length); //4
		System.out.println(array4.length); //6
		
		//#1-2. String �����ڸ� �̿��� ���ڿ� --> byte[]
		String str1 = new String(array1);
		String str2 = new String(array2, Charset.defaultCharset());
		String str3 = new String(array3, Charset.forName("MS949"));
		String str4 = new String(array4, "UTF-8");
		
		String str5 = new String(array3, "UTF-8");
		String str6 = new String(array4, "MS949");
		
		System.out.println(str1); //MS949->MS949
		System.out.println(str2); //MS949->MS949
		System.out.println(str3); //MS949->MS949
		System.out.println(str4); //UTF-8->UTF-8
		System.out.println(str5); //MS949->UTF-8 (����)
		System.out.println(str6); //UTF-8->MS949 (����)
		//System.out.println(File.pathSeparator +"/" +File.separator); ;/\
		
	}
}

