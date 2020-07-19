package pack01_stream.sec02_IntermediateOperations.EX03_Iterating_Peek;

import java.util.stream.IntStream;

public class EX03_Iterating_Peek {
	public static void main(String[] args) {
		
		//#2. iterating: peek(Consumer<T> c){
		int sum = IntStream.of(1,2,3,4,5).peek(s->System.out.println(s)).sum();
		System.out.println(sum);

		//주의 최종단계 없이는 중간단계는 동작하지 않음
		IntStream.of(1,2,3,4,5).peek(s->System.out.println(s));//동작하지 않음

	}
}
