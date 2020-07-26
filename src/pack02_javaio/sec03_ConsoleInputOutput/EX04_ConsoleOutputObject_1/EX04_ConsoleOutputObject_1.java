package pack02_javaio.sec03_ConsoleInputOutput.EX04_ConsoleOutputObject_1;

import java.io.IOException;
import java.io.OutputStream;

/*write(.) �޼��带 �̿��� �ܼ�(Console)�� ������ ����ϱ�(���������� ���)*/

public class EX04_ConsoleOutputObject_1 {
	public static void main(String[] args) throws IOException {

		//# OutputStream ����(�ܼ�)
		OutputStream os = System.out;

		//#1. 1-byte ���� ����		
		os.write('J');
		os.write('A');
		os.write('V');
		os.write('A');
		os.write(13); //carriage return 
		os.write(10); //line feed

		os.flush();
		
		//#2-1. n-byte ���� ���� (byte[]�� ó�� ��ġ���� ���� �������� ���) 
		byte[] byteArray1 = "Hello!".getBytes();
		os.write(byteArray1);
		os.write('\n');
		os.flush();

		//#3-1. n-byte ���� ���� (byte[]�� offset ��ġ�������� length������ �о�� ���) 
		byte[] byteArray2 = "Better the last smile than the first laughter.".getBytes();
		os.write(byteArray2, 7, 8);
		os.flush();
		
	}
}
