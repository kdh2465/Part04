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
		//#���� ����
		File orgfile = new File("src/pack03_javaio/sec04_files/mycat_origin.jpg");
		File copyfile1 = new File("src/pack03_javaio/sec04_files/mycat_copy1.jpg");
		File copyfile2 = new File("src/pack03_javaio/sec04_files/mycat_copy2.jpg");
		if(!copyfile1.exists()) copyfile1.createNewFile(); //outputstream���� ������ ���� ���� ��������
		if(!copyfile2.exists()) copyfile2.createNewFile(); //������ ������ �����Ͽ� �ۼ� FileOutputStream
		
		//#BufferedXXXStream�� ������� ���� ���
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
		
		//#BufferedXXXStream�� ����� ���
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

		//����Ѱ��� ������� ���� ����� ��
		System.out.println("Ratio of with and without : " + (time1/time2));

	}
}
