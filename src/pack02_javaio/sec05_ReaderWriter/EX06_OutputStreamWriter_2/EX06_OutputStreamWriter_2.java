package pack02_javaio.sec05_ReaderWriter.EX06_OutputStreamWriter_2;

import java.io.IOException;
import java.io.OutputStreamWriter;

/*MS949 문자셋과 UTF-8문자셋을 이용하여 콘솔(console)에 각각 출력하기*/

public class EX06_OutputStreamWriter_2 {
	public static void main(String[] args) throws IOException {
		
		//#1.콘솔 출력: OutputStreamWriter를 사용하여 문자단위 콘솔 출력하기 (MS949 타입 출력) Windows 기준
		try{ //MS949
		    OutputStreamWriter osw = new OutputStreamWriter(System.out, "MS949");
		    osw.write("OutputStreamWriter를 이용한\n".toCharArray());
		    osw.write("콘솔출력 예제입니다.\n한글과 영문이 모두 포함되어 있습니다.");
		    osw.write('\n');
		    osw.write("Good Bye!!!\n");
		    osw.flush();
		    System.out.println(osw.getEncoding());// MS949
		} catch(IOException e) {}
		

		//#2. 콘솔 출력: OutputStreamWriter를 사용하여 문자단위 콘솔 출력하기 (UTF-8 타입 출력) 한글깨짐
		try{ //UTF-8
		    OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
		    osw.write("OutputStreamWriter를 이용한\n".toCharArray());
		    osw.write("콘솔출력 예제입니다.\n한글과 영문이 모두 포함되어 있습니다.");
		    osw.write('\n');
		    osw.write("Good Bye!!!\n");
		    osw.flush();
		    System.out.println(osw.getEncoding());// UTF-8
		} catch(IOException e) {}
	}
}
