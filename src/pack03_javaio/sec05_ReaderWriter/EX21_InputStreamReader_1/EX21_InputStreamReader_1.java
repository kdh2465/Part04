package pack03_javaio.sec05_ReaderWriter.EX21_InputStreamReader_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class EX21_InputStreamReader_1 {
	public static void main(String[] args) {
		//#.파일 객체 선언
		File inputStreamReader = new File("sec05.files/InputStreamReader.txt");

		//#1. FileReader만을 이용하여 읽어오기 (UTF-8 모드 파일(메모장)) : Windows에서 깨짐
		try(Reader reader = new FileReader(inputStreamReader);){
		    int data;
		    while((data=reader.read())!=-1) {System.out.print((char)data); }
		} catch(IOException e) {}
		System.out.println(); System.out.println();

		//#2. FileInputStream+InputStreamReader를 사용하여 읽어오기(UTF-8 모드 파일(메모장))
		try(InputStream is = new FileInputStream(inputStreamReader);
		    InputStreamReader isr = new InputStreamReader(is, "UTF-8")){ //MS949
		        int data;
		        while((data=isr.read())!=-1) { System.out.print((char)data); }
		        System.out.println("\n"+isr.getEncoding());//UTF8
		} catch(IOException e) {}

	}
}
