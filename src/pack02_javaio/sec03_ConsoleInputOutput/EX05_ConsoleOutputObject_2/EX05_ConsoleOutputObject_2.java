package pack02_javaio.sec03_ConsoleInputOutput.EX05_ConsoleOutputObject_2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/*write(.) �޼��带 �̿��� �ܼ�(Console)�� ������ ����ϱ�(�ѱ۵����� ���)*/

public class EX05_ConsoleOutputObject_2 {
	public static void main(String[] args) throws IOException {

		//# OutputStream ����(�ܼ�)
		OutputStream os = System.out;

		//#2-2. n-byte ���� ���� (byte[]�� ó�� ��ġ���� ���� �������� ���) 
		byte[] byteArray1 = "�ȳ��ϼ���".getBytes(Charset.forName("MS949"));
		os.write(byteArray1);
		os.write('\n');
		os.flush();

		//#3-2. n-byte ���� ���� (byte[]�� offset ��ġ�������� length������ �о�� ���) 
		byte[] byteArray2 = "�ݰ����ϴ�".getBytes(Charset.defaultCharset());
		os.write(byteArray2, 4, 4);
		os.flush();
		
	}
}
