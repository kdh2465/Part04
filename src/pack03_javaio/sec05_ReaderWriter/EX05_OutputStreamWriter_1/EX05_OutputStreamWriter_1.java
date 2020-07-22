package pack03_javaio.sec05_ReaderWriter.EX05_OutputStreamWriter_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class EX05_OutputStreamWriter_1 {
	public static void main(String[] args) throws IOException {
		//#.���� ��ü ����
		File outputStreamWriter1 = new File("src/pack03_javaio/sec05_files/OutputStreamWriter1.txt");
		if(! outputStreamWriter1.exists()) outputStreamWriter1.createNewFile(); //��������

		//#1. FileWriter���� �̿��Ͽ� ���Ͼ��� (����Ʈ(ANSI))
		try(Writer writer = new FileWriter(outputStreamWriter1);){
		    writer.write("OutputStreamWriter1 ���������Դϴ�.\n".toCharArray());
		    writer.write("�ѱ۰� ������ ��� ���ԵǾ� �ֽ��ϴ�.");
		    writer.write('\n');
		    writer.write("Good Bye!!!\n\n");
		    writer.flush();
		}
		catch(IOException e) {}
		
		//#.���� ��ü ����
		File outputStreamWriter2 = new File("src/pack03_javaio/sec05_files/OutputStreamWriter2.txt");
		if(! outputStreamWriter2.exists()) outputStreamWriter2.createNewFile(); //��������

		//#2. FileOutputStream+OutputStreamWriter�� ����Ͽ� ���Ͼ���(UTF-8 ��� ����(�޸���))
		try(OutputStream os = new FileOutputStream(outputStreamWriter2, false);
		        OutputStreamWriter isr = new OutputStreamWriter(os, "UTF-8")){
		    isr.write("OutputStreamWriter2 ���������Դϴ�.\n".toCharArray());
		    isr.write("�ѱ۰� ������ ��� ���ԵǾ� �ֽ��ϴ�.");
		    isr.write('\n');
		    isr.write("Good Bye!!!\n");
		    isr.flush();
		    System.out.println(isr.getEncoding());//UTF8
		}
		catch(IOException e) {}

	}
}
