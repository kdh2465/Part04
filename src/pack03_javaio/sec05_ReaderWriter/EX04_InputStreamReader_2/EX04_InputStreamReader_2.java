package pack03_javaio.sec05_ReaderWriter.EX04_InputStreamReader_2;

import java.io.IOException;
import java.io.InputStreamReader;

public class EX04_InputStreamReader_2 {
	public static void main(String[] args) {
		
		//#1.콘솔 입력: InputStreamReader를 사용하여 콘솔 입력 읽어오기 (MS949 타입으로 읽기)
		try{ //MS949
			InputStreamReader isr = new InputStreamReader(System.in, "MS949");
		    int data;
		    while((data=isr.read())!='\r') { System.out.print((char)data); }
		    System.out.println("\n"+isr.getEncoding());//MS949
		} catch(IOException e) {}		
		
		//#2.콘솔 입력: InputStreamReader를 사용하여 콘솔 입력 읽어오기 (UTF-8 타입으로 읽기) : 한글깨짐
		try{
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
        	int data;
	        while((data=isr.read())!='\r') { System.out.print((char)data); }
	        System.out.println("\n"+isr.getEncoding());//UTF8
		} catch(IOException e) {}


	}
}
