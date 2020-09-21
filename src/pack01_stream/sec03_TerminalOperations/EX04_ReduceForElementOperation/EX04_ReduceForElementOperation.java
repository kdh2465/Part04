package pack01_stream.sec03_TerminalOperations.EX04_ReduceForElementOperation;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*스트림 요소간의 임의 연산 : reduce()*/

public class EX04_ReduceForElementOperation {
	public static void main(String[] args) {
		
		//CASE#1 
		//@1-1. BinaryOperator<T> acuumulator
		Optional<String> reduce1 = Stream.of("안녕","방가","감사")
				.reduce((a,b)->a+b);
		System.out.println(reduce1.get());

		//@1-2. IntBinaryOperator acuumulator
		OptionalInt reduce2 = IntStream.of(1,2,3,4,5)
                .reduce((a,b)->a+b);
		System.out.println(reduce2.getAsInt());

		
		//CASE#2 
		//@2-1. T identity, BinaryOperator<T> acuumulator
		String reduce3 = Stream.of("안녕","방가","감사")
				.reduce("#", (a,b)->a+b);
		System.out.println(reduce3);

		//@2-2. int identity, IntBinaryOperator acuumulator
		int reduce4 = IntStream.of(1,2,3,4,5)
                .reduce(5, (a,b)->a+b);
		System.out.println(reduce4);
		
		
		//CASE#3
		//@3-1. 순차스트림 (sequential stream)
		Integer reduce5 = Arrays.asList(1,2,3).stream()
				.reduce(
						5,
						(a,b)->{System.out.println("accumulate 호출"); return a+b;},
						(a,b)->{System.out.println("combine 호출"); return a+b;}
						);
		System.out.println(reduce5);
		
		//@3-2. 병렬스트림 (parallel stream)
		Integer reduce6 = Arrays.asList(1,2,3).parallelStream()
				.reduce(
						5,
						(a,b)->{System.out.println("accumulate 호출");return a+b;},
						(a,b)->{System.out.println("combine 호출");return a+b;}
						);
		System.out.println(reduce6);
		
	}
}
