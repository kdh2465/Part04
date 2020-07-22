package pack03_javaio.sec04_FilterInputOutputStream.EX18_PrintStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class EX18_PrintStream {
	public static void main(String[] args) throws IOException {
		
		//#File °´Ã¼ »ý¼º ¹× OutputStream °´Ã¼ »ý¼º (PrintStream)
		File outFile1 = new File("src/pack03_javaio/sec04_files/PrintStream1.txt");
		File outFile2 = new File("src/pack03_javaio/sec04_files/PrintStream2.txt");
		if(!outFile1.exists()) outFile1.createNewFile();
		if(!outFile2.exists()) outFile2.createNewFile();

		//#1. PrintStream(FileOutputStream(File))
		try(OutputStream os1 = new FileOutputStream(outFile1);
		     PrintStream ps = new PrintStream(os1)){
		         ps.println(5.8);
		         ps.print(3 + " ¾È³ç " + 12345 + "\n");
		         ps.printf("%d ", 7).printf("%s %f", "¾È³ç", 5.8);
		         ps.println();
		} catch(IOException e) { }
		
		//#2. PrintStream(File)
		try(PrintStream ps = new PrintStream(outFile2)){
			ps.println(5.8);
			ps.print(3 + " ¾È³ç " + 12345 + "\n");
			ps.printf("%d ", 7).printf("%s %f", "¾È³ç", 5.8);
			ps.println();
		}catch(IOException e) { }

		//#3. PrintStream = System.out
		try(OutputStream os2 = System.out;
			PrintStream ps = new PrintStream(os2)){
			ps.println(5.8);
			ps.print(3 + " ¾È³ç " + 12345 + "\n");
			ps.printf("%d ", 7).printf("%s %f", "¾È³ç", 5.8);
			ps.println();
		}catch(IOException e) { }		
		
	}
}
