package pack05_stream.sec01_CreateStreamObject.EX04_StreamStaticToStream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*Stream 클래스의 정적메서드를 활용한 Stream<E> 객체 생성*/

public class EX04_StreamStaticToStream {
	public static void main(String[] args) {
		
		//#1.빈 Stream 객체 생성 empty()
		Stream<String> stream1 = Stream.<String>empty();
		stream1.forEach(s->System.out.print(s+" "));
		
		//#2.builder(), add(), build를 이용하여 데이터를 가진 steam 만들기
		Stream<String> stream2 = Stream.<String>builder().add("땡큐").add("베리").add("감사").build();
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#3. T... values의 형태로 넘겨준 데이터를 가지는 Stream 객체 생성 of()
		Stream<String> stream3 = Stream.of("안녕", "방가", "잘가");
		stream3.forEach(s->System.out.print(s+" "));
		System.out.println();

		IntStream stream4 = IntStream.of(1,2,3);
		stream4.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		LongStream stream5 = LongStream.of(4L,5L,6L);
		stream5.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		DoubleStream stream6 = DoubleStream.of(7.7,8.8,9.9);
		stream6.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#4.동일한 값(초기값)을 가지는 Stream객체 생성 generate()
		Stream<Integer> stream7 = Stream.generate(()->-1).limit(5);
		stream7.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#5.초기값부터 연산결과를 저장하는 Stream 객체 생성 iterate()
		Stream<Integer> stream8 = Stream.iterate(0, n->(n+1)).limit(5);
		stream8.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#6. 두 개의 스트림 연결하여 새로운 Stream 객체 생성 concat()
		Stream<String> stream9_1 = Stream.of("안녕", "방가", "잘가");
		Stream<String> stream9_2 = Stream.of("땡큐", "베리", "감사");
		Stream<String> stream9 = Stream.concat(stream9_1, stream9_2);
		stream9.forEach(s->System.out.print(s+" "));
		
	}
}
