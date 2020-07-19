package pack03_javaio.sec05_ReaderWriter.EX19_FileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class EX19_FileReaderWriter {
	public static void main(String[] args) {
		//#.���� ��ü ����
		File readerwriterFile = new File("sec05.files/ReaderWriterFile.txt");

		//#1. FileWriter�� �̿��� ���� ���� (ANSI ���)
		try(Writer writer = new FileWriter(readerwriterFile);){
		    writer.write("�ȳ��ϼ���\n".toCharArray());
		    writer.write("Hello");
		    writer.write('\r');
		    writer.write('\n');
		    writer.write("�ݰ����ϴ�", 2, 3);
		    writer.flush();
		}
		catch(IOException e) {}
		//#2. FileReader�� �̿��� ���� �б� (ANSI ���)
		try(Reader reader = new FileReader(readerwriterFile);){
		    int data;
		    while((data=reader.read())!=-1) {
		        System.out.print((char)data);
		    }
		}
		catch(IOException e) {}
	}
}