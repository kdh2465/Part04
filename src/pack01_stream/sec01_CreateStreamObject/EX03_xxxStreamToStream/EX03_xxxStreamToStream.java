package pack01_stream.sec01_CreateStreamObject.EX03_xxxStreamToStream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*기본자료형스트림(Int/Long/DoubleStream)으로부터 Stream<E> 객체 생성*/

public class EX03_xxxStreamToStream {
	public static void main(String[] args) {
		
		//#1. int[] -> IntStream -> Stream<Integer>
		int[] intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		Stream<Integer> stream1 = intStream.boxed();
		
		//#2. long[] -> LongStream -> Stream<Long>		
		long[] longArray = {3L,4L,5L,6L,7L};
		LongStream longStream = Arrays.stream(longArray);
		Stream<Long> stream2=longStream.boxed();

		//#3. double[] -> DoubleStream -> Stream<Double>
		double[] doubleArray = {5.5,6.6,7.7,8.8,9.9};
		DoubleStream doubleStream = Arrays.stream(doubleArray);
		Stream<Double> stream3=doubleStream.boxed();
		
		//#. 연결표현
		Stream<Integer> stream4=Arrays.stream(intArray).boxed();
		Stream<Long> stream5=Arrays.stream(longArray).boxed();
		Stream<Double> stream6=Arrays.stream(doubleArray).boxed();

		
	}
}
