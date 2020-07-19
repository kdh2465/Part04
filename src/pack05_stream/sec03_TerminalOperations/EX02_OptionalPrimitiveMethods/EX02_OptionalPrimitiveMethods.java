package pack05_stream.sec03_TerminalOperations.EX02_OptionalPrimitiveMethods;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*Optional+XXX 클래스의 주요 메서드*/

public class EX02_OptionalPrimitiveMethods {
	public static void main(String[] args) {
		
		//#. OptionalXXX 메서드 (isPrsent(), ifPresent(), orElse(), getAsXXX()
		//#1. isPrsent()
		System.out.println(IntStream.of().min().isPresent()); //false
		
		//#2. ifPresent()
		DoubleStream.of(5.8, 7.6).max().ifPresent(s->System.out.println(s)); //7.6
		
		//#3. orElse()
		//System.out.println(LongStream.of().average().getAsDouble());//NoSuchElementException
		System.out.println(LongStream.of().average().orElse(0.0)); //0.0
		
		//#4. getAsXXX()
		System.out.println(LongStream.of(3L,4L).min().getAsLong());//3
		
	}
}
