package pack03_javaio.sec05_ReaderWriter.EX22_InputStreamReader_2;

import java.io.IOException;
import java.io.InputStreamReader;

public class EX22_InputStreamReader_2 {
	public static void main(String[] args) {
		
		//#1.�ܼ� �Է�: InputStreamReader�� ����Ͽ� �ܼ� �Է� �о���� (MS949 Ÿ������ �б�)
		try{ //MS949
			InputStreamReader isr = new InputStreamReader(System.in);
		    int data;
		    while((data=isr.read())!='\r') { System.out.print((char)data); }
		    System.out.println("\n"+isr.getEncoding());//MS949
		} catch(IOException e) {}		
		
		//#2.�ܼ� �Է�: InputStreamReader�� ����Ͽ� �ܼ� �Է� �о���� (UTF-8 Ÿ������ �б�) : �ѱ۱���
		try{
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
        	int data;
	        while((data=isr.read())!='\r') { System.out.print((char)data); }
	        System.out.println("\n"+isr.getEncoding());//UTF8
		} catch(IOException e) {}


	}
}
