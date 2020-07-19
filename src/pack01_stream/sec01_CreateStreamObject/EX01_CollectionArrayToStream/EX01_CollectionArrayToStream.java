package pack05_stream.sec01_CreateStreamObject.EX01_CollectionArrayToStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*컬렉션 및 배열로부터 Stream<E> 객체 생성*/

public class EX01_CollectionArrayToStream {
	public static void main(String[] args) throws IOException {
		
		//#1-1.컬렉션 --> 스트림
		List<String> list = Arrays.asList("가","나","다");
		Stream<String> stream1 = list.stream();
		stream1.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#1-2.컬렉션 --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Arrays.asList("가","나","다").stream().forEach(s->System.out.print(s+" "));
		System.out.println();
		
		
		//#2-1. 객체 배열 --> 스트림
		Integer[] array = {1,2,3,4,5};
		Stream<Integer> stream2 = Arrays.stream(array);
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#2-2. 객체 배열 --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Arrays.stream(array).forEach(s->System.out.print(s+" "));
		System.out.println();
	
	}
}
