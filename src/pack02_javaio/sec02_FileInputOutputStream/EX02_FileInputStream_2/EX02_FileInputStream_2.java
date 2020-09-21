package pack02_javaio.sec02_FileInputOutputStream.EX02_FileInputStream_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*FileInputStream의 read(.) 메서드를 이용한 데이터 읽기 (영문파일 읽기)*/

public class EX02_FileInputStream_2 {
	public static void main(String[] args) throws IOException {
		//입력파일 생성
		File inFile = new File("src/pack03_javaio/sec02_files/FileInputStream1.txt ");

		//#1. 1-byte 단위 읽기
		InputStream is1 = new FileInputStream(inFile);
		int data;
		while((data=is1.read())!= -1 ) { 
		  System.out.print((char)data);
		}
		System.out.println(); System.out.println();
		
		
		//#2-1. n-byte 단위 읽기 (byte[]의 처음 위치에서 부터 읽은 데이터 저장) 
		byte[] byteArray1 = new byte[9];
		InputStream is2 = new FileInputStream(inFile);
		int count1;
		while((count1 = is2.read(byteArray1))!=-1) { 
			for(int i=0; i<count1; i++)
				System.out.print((char)byteArray1[i]);
			System.out.println(" : count="+count1);
		}
		System.out.println(); System.out.println();

		
		//#3-1. n-byte 단위 입력 (length만큼의 길이를 읽어와 byte[]의 offset 위치에서 부터 저장) 
		byte[] byteArray2 = new byte[9];
		InputStream is3 = new FileInputStream(inFile);
		int offset=3; int length=6;
		int count2 = is3.read(byteArray2, offset, length);//offset:3 length:6		
		for(int i=0; i<offset+count2; i++)
			System.out.print((char)byteArray2[i]);		
		
		//#InputStream 자원 반납
		is1.close();
		is2.close();
		is3.close();
				
	}
}
