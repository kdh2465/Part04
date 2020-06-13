package pack03_javaio.sec05_ReaderWriter.EX20_BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class EX20_BufferedReaderWriter {
	public static void main(String[] args) throws IOException {
		//#.파일 객체 선언
		File buffredFile = new File("sec05.files/BuffredFile.txt");
		if(!buffredFile.exists()) buffredFile.createNewFile();

		// #1. FileWriter/BufferedWriter를 이용한 파일 쓰기 (ANSI 모드)
		try (Writer writer = new FileWriter(buffredFile); 
				BufferedWriter bw = new BufferedWriter(writer);) {
			bw.write("안녕하세요\n".toCharArray());
			bw.write("Hello");
			bw.write('\n');
			bw.write("반갑습니다", 2, 3);
			bw.flush();
		} catch (IOException e) {}

		// #2. FileReader/BufferedReader를 이용한 파일 읽기 (ANSI 모드)
		try (Reader reader = new FileReader(buffredFile); 
				BufferedReader br = new BufferedReader(reader);) {
			String data;
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {}	
	}
}
