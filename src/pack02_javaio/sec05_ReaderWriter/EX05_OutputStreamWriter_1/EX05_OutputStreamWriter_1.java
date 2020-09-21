package pack02_javaio.sec05_ReaderWriter.EX05_OutputStreamWriter_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*FileWriter와 OutputStreamWriter를 이용하여 각각 파일 쓰기*/

public class EX05_OutputStreamWriter_1 {
	public static void main(String[] args) throws IOException {
		//#.파일 객체 선언
		File outputStreamWriter1 = new File("src/pack03_javaio/sec05_files/OutputStreamWriter1.txt");
		if(! outputStreamWriter1.exists()) outputStreamWriter1.createNewFile(); //생략가능

		//#1. FileWriter만을 이용하여 파일쓰기 (디폴트(ANSI))
		try(Writer writer = new FileWriter(outputStreamWriter1);){
		    writer.write("OutputStreamWriter1 예제파일입니다.\n".toCharArray());
		    writer.write("한글과 영문이 모두 포함되어 있습니다.");
		    writer.write('\n');
		    writer.write("Good Bye!!!\n\n");
		    writer.flush();
		}
		catch(IOException e) {}
		
		//#.파일 객체 선언
		File outputStreamWriter2 = new File("src/pack03_javaio/sec05_files/OutputStreamWriter2.txt");
		if(! outputStreamWriter2.exists()) outputStreamWriter2.createNewFile(); //생략가능

		//#2. FileOutputStream+OutputStreamWriter를 사용하여 파일쓰기(UTF-8 모드 파일(메모장))
		try(OutputStream os = new FileOutputStream(outputStreamWriter2, false);
		        OutputStreamWriter isr = new OutputStreamWriter(os, "UTF-8")){
		    isr.write("OutputStreamWriter2 예제파일입니다.\n".toCharArray());
		    isr.write("한글과 영문이 모두 포함되어 있습니다.");
		    isr.write('\n');
		    isr.write("Good Bye!!!\n");
		    isr.flush();
		    System.out.println(isr.getEncoding());//UTF8
		}
		catch(IOException e) {}

	}
}
