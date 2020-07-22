package pack03_javaio.sec05_ReaderWriter.EX24_OutputStreamWriter_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class EX24_OutputStreamWriter_2 {
	public static void main(String[] args) throws IOException {
		
		//#1.�ܼ� ���: OutputStreamWriter�� ����Ͽ� ���ڴ��� �ܼ� ����ϱ� (MS949 Ÿ�� ���) Windows ����
		try{ //MS949
		    OutputStreamWriter osw = new OutputStreamWriter(System.out);
		    osw.write("OutputStreamWriter�� �̿���\n".toCharArray());
		    osw.write("�ܼ���� �����Դϴ�.\n�ѱ۰� ������ ��� ���ԵǾ� �ֽ��ϴ�.");
		    osw.write('\n');
		    osw.write("Good Bye!!!\n");
		    osw.flush();
		    System.out.println(osw.getEncoding());// MS949
		} catch(IOException e) {}
		

		//#2. �ܼ� ���: OutputStreamWriter�� ����Ͽ� ���ڴ��� �ܼ� ����ϱ� (UTF-8 Ÿ�� ���) �ѱ۱���
		try{ //MS949
		    OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
		    osw.write("OutputStreamWriter�� �̿���\n".toCharArray());
		    osw.write("�ܼ���� �����Դϴ�.\n�ѱ۰� ������ ��� ���ԵǾ� �ֽ��ϴ�.");
		    osw.write('\n');
		    osw.write("Good Bye!!!\n");
		    osw.flush();
		    System.out.println(osw.getEncoding());// UTF-8
		} catch(IOException e) {}
	}
}
