package pack01_stream.sec03_TerminalOperations.EX05_CollectForNewDataSet_1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*스트림으로부터의 새로운 수집(collect) 조합 구성 : collect() #1*/

public class EX05_CollectForNewDataSet_1 {
	public static void main(String[] args) {
		
		//Case#1 Collection Type 구성 (List,Set,Map)
		//@1-1. Collectors.toList()
		List<Integer> intList = Stream.of(1,2,3,4,5).collect(Collectors.toList());
		System.out.println(intList);
		//@1-2.Collectors.toSet()
		Set<String> strSet = Stream.of("안녕","방가","땡큐","안녕").collect(Collectors.toSet());
		System.out.println(strSet);
		//@1-3.Collectors.toMap(keyMapper, valueMapper)
		Map<Integer, String> strMap = Stream.of("안녕","방가워","또만나요").collect(Collectors.toMap(s->s.length(), s->s));
		System.out.println(strMap);
		
		
		//Case#2 Stirng stream의 요소의 결합 String 수집 조합
		//@2-1.joining()
		String str1 = Stream.of("땡큐","베리","감사").collect(Collectors.joining());
		System.out.println(str1);
		//@2-1.joining(delimiter, prefix, suffix)
		String str2 = Stream.of("땡큐","베리","감사").collect(Collectors.joining(":","[","]"));
		System.out.println(str2);

		
		//Case#3. 요소값의 기본연산 결과 수집 조합 (cf. xxxStream의 경우 직접 average(), sum() 사용가능)
		//@3-1. counting() //cf. count()는 xxxStream, Stream<T>에서 모두 사용가능
		long count = Stream.of(1,2,3,4).collect(Collectors.counting()); System.out.println(count);		
		//@3-2. averagingXXX()
		double avg1 = Stream.of(1,2,3,4).collect(Collectors.averagingInt(s->s));
		double avg2 = Stream.of(5L,6L,7L,8L).collect(Collectors.averagingLong(s->s));
		double avg3 = Stream.of(1.1,2.2,3.3,4.4).collect(Collectors.averagingDouble(s->s));		
		System.out.println(avg1 + ", " + avg2 + ", " + avg3);		
		//@3-3. summingXXX()
		int sum1 = Stream.of(1,2,3,4).collect(Collectors.summingInt(s->s));
		long sum2 = Stream.of(5L,6L,7L,8L).collect(Collectors.summingLong(s->s));
		double sum3 = Stream.of(1.1,2.2,3.3,4.4).collect(Collectors.summingDouble(s->s));
		System.out.println(sum1 + ", " + sum2 + ", " + sum3);

	}
}
