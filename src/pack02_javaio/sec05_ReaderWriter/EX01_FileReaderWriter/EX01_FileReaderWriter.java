﻿package pack02_javaio.sec05_ReaderWriter.EX01_FileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*FileReader와 FileWriter를 이용한 char 단위의 파일입출력 구현*/

public class EX01_FileReaderWriter {
	public static void main(String[] args) {
		//#.파일 객체 선언
		File readerwriterFile = new File("src/pack03_javaio/sec05_files/ReaderWriterFile.txt");

		//#1. FileWriter를 이용한 파일 쓰기 (ANSI 모드)
		try(Writer writer = new FileWriter(readerwriterFile);){
		    writer.write("안녕하세요\n".toCharArray());
		    writer.write("Hello");
		    writer.write('\r');
		    writer.write('\n');
		    writer.write("반갑습니다", 2, 3);
		    writer.flush();
		}
		catch(IOException e) {}
		
		//#2. FileReader를 이용한 파일 읽기 (ANSI 모드)
		try(Reader reader = new FileReader(readerwriterFile);){
		    int data;
		    while((data=reader.read())!=-1) {
		        System.out.print((char)data);
		    }
		}
		catch(IOException e) {}
	}
}
