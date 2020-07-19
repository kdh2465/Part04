package pack01_stream.EX01_IteratorVsStream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class EX01_IteratorVsStream {
	public static void main(String[] args) {
		
		//#1. 외부반복자 (iterator)
		List<Integer> list1 = Arrays.asList(2,1,3,5);
		Iterator<Integer> iterator = list1.iterator();
		while(iterator.hasNext()) {
		  System.out.print(iterator.next()+" "); //2,1,3,5
		}
		System.out.println();
		
		//#2. 내부반복자 (stream)
		List<Integer> list2 = Arrays.asList(2,1,3,5);
		Stream<Integer> stream = list2.stream();
		stream.forEach(i->System.out.print(i+" ")); //2,1,3,5		

	}
}
