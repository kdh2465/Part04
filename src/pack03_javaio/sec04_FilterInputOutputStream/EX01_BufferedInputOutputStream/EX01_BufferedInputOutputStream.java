package pack03_javaio.sec04_FilterInputOutputStream.EX15_BufferedInputOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EX15_BufferedInputOutputStream {
	public static void main(String[] args) throws IOException {
		//#파일 생성
		File orgfile = new File("src/pack03_javaio/sec04_files/mycat_origin.jpg");
		File copyfile1 = new File("src/pack03_javaio/sec04_files/mycat_copy1.jpg");
		File copyfile2 = new File("src/pack03_javaio/sec04_files/mycat_copy2.jpg");
		if(!copyfile1.exists()) copyfile1.createNewFile(); //outputstream으로 파일을 쓰는 경우는 생략가능
		if(!copyfile2.exists()) copyfile2.createNewFile(); //파일이 없으면 생성하여 작성 FileOutputStream
		
		//#BufferedXXXStream을 사용하지 않은 경우
		long start, end, time1, time2;
		start = System.nanoTime();
		try(InputStream is = new FileInputStream(orgfile);
		    OutputStream os = new FileOutputStream(copyfile1);){
		        int data;
		        while((data = is.read())!=-1) { os.write(data); }
		        os.flush();
		}catch(IOException e) {e.printStackTrace();}
		end = System.nanoTime();
		time1 = end-start;
		System.out.println("Without BufferedXXXStream : " + (time1));
		
		//#BufferedXXXStream을 사용한 경우
		start = System.nanoTime();
		try(InputStream is = new FileInputStream(orgfile);
		    BufferedInputStream bis = new BufferedInputStream(is);
		    OutputStream os = new FileOutputStream(copyfile2);
		    BufferedOutputStream bos = new BufferedOutputStream(os);){

		        int data;
		        while((data = bis.read())!=-1) { bos.write(data); }
		        bos.flush();
		}catch(IOException e) {}
		end = System.nanoTime();
		time2 = end-start;
		System.out.println("With BufferedXXXStream : " + (time2));

		//사용한경우와 사용하지 않은 경우의 비
		System.out.println("Ratio of with and without : " + (time1/time2));

	}
}
