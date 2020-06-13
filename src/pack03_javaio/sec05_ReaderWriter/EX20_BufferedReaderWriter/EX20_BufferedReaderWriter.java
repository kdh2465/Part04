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
		//#.���� ��ü ����
		File buffredFile = new File("sec05.files/BuffredFile.txt");
		if(!buffredFile.exists()) buffredFile.createNewFile();

		// #1. FileWriter/BufferedWriter�� �̿��� ���� ���� (ANSI ���)
		try (Writer writer = new FileWriter(buffredFile); 
				BufferedWriter bw = new BufferedWriter(writer);) {
			bw.write("�ȳ��ϼ���\n".toCharArray());
			bw.write("Hello");
			bw.write('\n');
			bw.write("�ݰ����ϴ�", 2, 3);
			bw.flush();
		} catch (IOException e) {}

		// #2. FileReader/BufferedReader�� �̿��� ���� �б� (ANSI ���)
		try (Reader reader = new FileReader(buffredFile); 
				BufferedReader br = new BufferedReader(reader);) {
			String data;
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {}	
	}
}
