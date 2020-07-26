package pack02_javaio.sec05_ReaderWriter.EX06_OutputStreamWriter_2;

import java.io.IOException;
import java.io.OutputStreamWriter;

/*MS949 ���ڼ°� UTF-8���ڼ��� �̿��Ͽ� �ܼ�(console)�� ���� ����ϱ�*/

public class EX06_OutputStreamWriter_2 {
	public static void main(String[] args) throws IOException {
		
		//#1.�ܼ� ���: OutputStreamWriter�� ����Ͽ� ���ڴ��� �ܼ� ����ϱ� (MS949 Ÿ�� ���) Windows ����
		try{ //MS949
		    OutputStreamWriter osw = new OutputStreamWriter(System.out, "MS949");
		    osw.write("OutputStreamWriter�� �̿���\n".toCharArray());
		    osw.write("�ܼ���� �����Դϴ�.\n�ѱ۰� ������ ��� ���ԵǾ� �ֽ��ϴ�.");
		    osw.write('\n');
		    osw.write("Good Bye!!!\n");
		    osw.flush();
		    System.out.println(osw.getEncoding());// MS949
		} catch(IOException e) {}
		

		//#2. �ܼ� ���: OutputStreamWriter�� ����Ͽ� ���ڴ��� �ܼ� ����ϱ� (UTF-8 Ÿ�� ���) �ѱ۱���
		try{ //UTF-8
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
