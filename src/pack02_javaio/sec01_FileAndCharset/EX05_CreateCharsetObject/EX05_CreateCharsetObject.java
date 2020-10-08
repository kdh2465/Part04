package pack02_javaio.sec01_FileAndCharset.EX05_CreateCharsetObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;



public class EX05_CreateCharsetObject {
	public static void main(String[] args) throws UnsupportedEncodingException {
							

		Charset cs1 = Charset.defaultCharset(); //x-windows-949		
		Charset cs2 = Charset.forName("MS949");
		Charset cs3 = Charset.forName("UTF-8");
				
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs3);
		
		System.out.println(Charset.isSupported("MS949"));
		System.out.println(Charset.isSupported("UTF-8"));
		
	}
}
