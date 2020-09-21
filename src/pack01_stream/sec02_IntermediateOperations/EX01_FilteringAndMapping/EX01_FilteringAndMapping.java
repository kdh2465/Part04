package pack01_stream.sec02_IntermediateOperations.EX01_FilteringAndMapping;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*필터링(filtering)과 맵핑(Mapping) 및 필터링/매핑 연속 호출*/

public class EX01_FilteringAndMapping {
	public static void main(String[] args) {
		//#1. filtering
		Stream<String> stream1 = Stream.of("apple", "peach", "kiwi", "banana"); 
		stream1 = stream1.filter(s->s.contains("a"));
		stream1.forEach(s->System.out.println(s+" "));
		System.out.println();
		
		//#2. mapping
		//#2-1. mapping : map(Function<String, Integer> f) : String->Integer
		Stream<Integer> stream2 = Stream.of("1","2", "3","4")
				.map(s->Integer.parseInt(s));
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#2-2. mapping : map(ToIntFunction<String> f) : String -> int
		IntStream stream3 = Stream.of("apple","peach", "kiwi","banana")
			             .mapToInt(s->s.length());
		stream3.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#2-3. mapping : map(ToLongFunction<Integer> f) : Integer -> long
		LongStream stream4 = Stream.of(5, 6, 7, 8)
			.mapToLong(s->s.longValue());
		stream4.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#2-4. mapping : map(ToDoubleFunction<String> f): String-> double
		DoubleStream stream5 = Stream.of("5.2", "6.5", "7.8", "8.1")
			.mapToDouble(s->Double.parseDouble(s));
		stream5.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		
		//#3. filtering + mapping : Integer->짝수-->String
		Stream<String> stream6 = Stream.of(1, 2, 3, 4, 5, 6)
			.filter(s->(s%2)==0)
			.map(s->String.valueOf(s));
		stream6.forEach(s->System.out.print(s+" "));
		System.out.println();

	}
}
