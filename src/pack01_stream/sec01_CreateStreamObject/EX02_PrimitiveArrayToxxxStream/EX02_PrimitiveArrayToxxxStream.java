package pack01_stream.sec01_CreateStreamObject.EX02_PrimitiveArrayToxxxStream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*�⺻�ڷ��� �迭�κ��� �⺻�ڷ�����Ʈ��(Int/Long/DoubleStream) ����*/

public class EX02_PrimitiveArrayToxxxStream {
	public static void main(String[] args) {
		//#1-1.int[] --> ��Ʈ��
		int[] intArray = {1,2,3,4,5};
		IntStream stream1 = Arrays.stream(intArray);
		stream1.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#1-2.int[] --> ��Ʈ�� (����ǥ��) : ����(chaining) ȣ��
		Arrays.stream(intArray).forEach(s->System.out.print(s+" "));
		System.out.println();

		
		//#2-1.long[] --> ��Ʈ��
		long[] longArray = {3L,4L,5L,6L,7L};
		LongStream stream2 = Arrays.stream(longArray);
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#2-2.long[] --> ��Ʈ�� (���� ǥ��)
		Arrays.stream(longArray).forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#3-1.double[] --> ��Ʈ��
		double[] doubleArray = {5.5,6.6,7.7,8.8,9.9};
		DoubleStream stream3 = Arrays.stream(doubleArray);
		stream3.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#3-2.double[] --> ��Ʈ��
		Arrays.stream(doubleArray).forEach(s->System.out.print(s+" "));
		System.out.println();

	}
}
