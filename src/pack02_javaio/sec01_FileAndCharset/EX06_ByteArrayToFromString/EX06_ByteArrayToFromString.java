package pack02_javaio.sec01_FileAndCharset.EX06_ByteArrayToFromString;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/*String → byte[]와 byte[]→String 변환 */

public class EX06_ByteArrayToFromString {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		//#1-1. String의 getBytes()를 이용한 byte[] --> 문자열
		byte[] array1 = "안녕".getBytes();
		byte[] array2 = "땡큐".getBytes(Charset.defaultCharset());
		byte[] array3 = "베리".getBytes(Charset.forName("MS949"));
		byte[] array4 = "감사".getBytes("UTF-8");
		
		System.out.println(array1.length); //
		System.out.println(array2.length); //
		System.out.println(array3.length); //4
		System.out.println(array4.length); //6
		
		//#1-2. String 생성자를 이용한 문자열 --> byte[]
		String str1 = new String(array1);
		String str2 = new String(array2, Charset.defaultCharset());
		String str3 = new String(array3, Charset.forName("MS949"));
		String str4 = new String(array4, "UTF-8");
		
		String str5 = new String(array3, "UTF-8");
		String str6 = new String(array4, "MS949");
		
		System.out.println(str1); //defaultCharset->defaultCharset
		System.out.println(str2); //defaultCharset->defaultCharset
		System.out.println(str3); //MS949->MS949
		System.out.println(str4); //UTF-8->UTF-8
		System.out.println(str5); //MS949->UTF-8 (깨짐)
		System.out.println(str6); //UTF-8->MS949 (깨짐)
		
		
	}
}

