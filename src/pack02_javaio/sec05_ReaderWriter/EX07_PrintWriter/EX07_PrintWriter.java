package pack02_javaio.sec05_ReaderWriter.EX07_PrintWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*PrintWriter ��ü���� �� Ȱ�� (File, OutputStream, Writer, �ܼ� ���)*/

public class EX07_PrintWriter {
	public static void main(String[] args) throws IOException {
		//#.���� ��ü ����
		File printWriter1 = new File("src/pack03_javaio/sec05_files/PrintWriter1.txt");
		File printWriter2 = new File("src/pack03_javaio/sec05_files/PrintWriter2.txt");
		File printWriter3 = new File("src/pack03_javaio/sec05_files/PrintWriter3.txt");

		if(! printWriter1.exists()) printWriter1.createNewFile();
		if(! printWriter2.exists()) printWriter2.createNewFile();
		if(! printWriter3.exists()) printWriter3.createNewFile();

		//#1. PrintWriter(File file) ������
		try(PrintWriter pw = new PrintWriter(printWriter1);){
		    pw.println("PrintWriter ����#1");
		    pw.println(13); 
		    pw.println(5.8);
		    pw.print("�ȳ��ϼ���! ");
		    pw.println("�ݰ����ϴ�.");
		    pw.printf("%d",7).printf("%S %f", "����", 3.7);
		}
		catch(IOException e) {}
		
		//#2. PrintWriter(OutputStream os) ������
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(printWriter2));){
		    pw.println("PrintWriter ����#2");
		    pw.println(13); 
		    pw.println(5.8);
		    pw.print("�ȳ��ϼ���! ");
		    pw.println("�ݰ����ϴ�.");
		    pw.printf("%d",7).printf("%S %f", "����", 3.7);
		}
		catch(IOException e) {}

		//#3. PrintWriter(Writer w) ������
		try(PrintWriter pw = new PrintWriter(new FileWriter(printWriter3));){
		    pw.println("PrintWriter ����#3");
		    pw.println(13); 
		    pw.println(5.8);
		    pw.print("�ȳ��ϼ���! ");
		    pw.println("�ݰ����ϴ�.");
		    pw.printf("%d",7).printf("%S %f", "����", 3.7);
		}
		catch(IOException e) {}
		
		//#4. PrintWriter(System.out) ������ : �ܼ����		
		PrintWriter pw = new PrintWriter(System.out, true);
	    pw.println("PrintWriter ����#4");
	    pw.println(13); 
	    pw.println(5.8);
	    pw.print("�ȳ��ϼ���! ");
	    pw.println("�ݰ����ϴ�.");
	    pw.printf("%d",7).printf("%S %f", "����", 3.7);
	    
	}
}
