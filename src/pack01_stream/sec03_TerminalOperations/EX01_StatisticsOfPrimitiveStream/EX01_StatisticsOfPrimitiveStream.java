package pack01_stream.sec03_TerminalOperations.EX01_StatisticsOfPrimitiveStream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*기본자료형 스트림의 기본 통계 데이터 개별 추출*/

public class EX01_StatisticsOfPrimitiveStream {
	public static void main(String[] args) {
		
		//#1. count(), sum()
		long count = IntStream.of(1,2,3,4,5).count();
		System.out.println(count);
		int sum = IntStream.of(1,2,3,4,5).sum();
		System.out.println(sum);

		System.out.println(DoubleStream.of(1.2, 2.3).count());
		System.out.println(DoubleStream.of(1.2, 2.3).sum());

		
		//#2. min(), max(), average()
		OptionalInt min = IntStream.of(1,2,3,4,5).min();
		System.out.println(min.getAsInt()); //OptionalInt->int

		OptionalDouble max = DoubleStream.of(1.5,2.8,3.1,4.5,6.1).max();
		System.out.println(max.getAsDouble()); //OptionalDouble->double

		OptionalDouble avg = IntStream.of(1,2,3,4,5).average();
		System.out.println(avg.getAsDouble()); //OptionalDouble->double
		
		
		//#3. OptionalXXX 메서드 (isPrsent(), ifPresent(), orElse, getAsXXX()
		System.out.println(IntStream.of().min().isPresent()); //false
		DoubleStream.of(5.8, 7.6).max().ifPresent(s->System.out.println(s)); //7.6
		
		//System.out.println(LongStream.of().average().getAsDouble());//NoSuchElementException
		System.out.println(LongStream.of().average().orElse(0.0)); //0.0
		
		System.out.println(LongStream.of(3L,4L).min().getAsLong());//3

	}
}
