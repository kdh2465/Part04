package pack01_stream.sec01_CreateStreamObject.EX05_CreateParallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*병렬스트림(ParallelStream) 생성*/

public class EX05_CreateParallelStream {
	public static void main(String[] args) {
		//#1.컬렉션 --> 병렬(Parallel) 스트림
		List<String> list = Arrays.asList("가","나","다");
		Stream<String> stream1 = list.parallelStream();
		System.out.println("병렬여부: "+stream1.isParallel());//병렬여부확인
		stream1.forEach(s->System.out.print(s+" "));
		//stream1.forEach(s->System.out.print(s+" " + ": "+Thread.currentThread().getName()+"\n")); //순서가 바뀔수 있음
		System.out.println();
		
		//#2. 객체 배열 -> Stream<T> -> 병렬(Parallel) 스트림
		Integer[] array = {1,2,3,4,5};
		Stream<Integer> stream2 = Arrays.stream(array).parallel();
		System.out.println("병렬여부: "+stream2.isParallel());//병렬여부확인
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#3. 기본자료형배열 -> xxxStream -> 병렬(Parallel) 스트림 (Long, Double 동일)
		int[] intArray = {6,7,8,9,10};
		IntStream stream3 = Arrays.stream(intArray).parallel();
		System.out.println("병렬여부: "+stream3.isParallel());//병렬여부확인
		stream3.forEach(s->System.out.print(s+" "));
		System.out.println(); 
	}
}
