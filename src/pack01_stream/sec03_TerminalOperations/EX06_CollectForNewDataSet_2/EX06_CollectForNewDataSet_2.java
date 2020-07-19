package pack01_stream.sec03_TerminalOperations.EX06_CollectForNewDataSet_2;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX06_CollectForNewDataSet_2 {
	public static void main(String[] args) {
		
		//Case#4. XXXSummaryStatics 타입으로 기본연산 전체 결과 수집 조합 (getCount(), getSum(), getAverage(), getMax(), getMin()
		//@4-1. Int/Long/DoubleSummaryStatistics
		IntSummaryStatistics  iss = Stream.of(1,2,3,4).collect(Collectors.summarizingInt(s->s));
		LongSummaryStatistics  lss = Stream.of(5L,6L,7L,8L).collect(Collectors.summarizingLong(s->s));
		DoubleSummaryStatistics  dss = Stream.of(1.1,2.2,3.3,4.4).collect(Collectors.summarizingDouble(s->s));

		//@4-2. Int/Long/DoubleSummaryStatistics Methods(getCount(), getSum(), getAverage(), getMax(), getMin()
		System.out.println(iss.getCount()+", "+lss.getCount()+", "+dss.getCount());
		System.out.println(iss.getAverage()+", "+lss.getAverage()+", "+dss.getAverage());
		System.out.println(iss.getSum()+", "+lss.getSum()+", "+dss.getSum());
		System.out.println(iss.getMax()+", "+lss.getMax()+", "+dss.getMax());
		System.out.println(iss.getMin()+", "+lss.getMin()+", "+dss.getMin());
		
		
		//Case#5. 기준 Key값으로 Group별로 분리하여 Map<K, List<T>> 수집 조합
		Map<Integer, List<Integer>> groupBy = Stream.of(1,2,3,4).collect(Collectors.groupingBy(s->s%3));
		System.out.println(groupBy);

		
		//Case#6. 기준 조건의 만족여부에 따른 Group별로 분리하여 Map<Boolean, List<T>> 수집 조합
		Map<Boolean, List<Integer>> partitioningBy = Stream.of(18,16,20,60,14,30).collect(Collectors.partitioningBy(s->s>20));
		System.out.println(partitioningBy);
		
		
		//Case#7. 수집 조합 구성(collector) 이후 추가 수행사항 지정
		List<Integer> list = Stream.of(1,2,3,4).collect(Collectors.collectingAndThen(Collectors.toList(), s->s.subList(1,3)));
		System.out.println(list);//[2,3]

		boolean data = Stream.of(3,2,1,4).collect(Collectors.collectingAndThen(Collectors.toSet(), s->s.contains(1)));
		System.out.println(data);



	}
}
