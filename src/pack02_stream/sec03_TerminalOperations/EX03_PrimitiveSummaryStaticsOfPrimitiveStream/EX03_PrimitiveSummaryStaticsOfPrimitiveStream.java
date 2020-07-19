package pack01_stream.sec03_TerminalOperations.EX03_PrimitiveSummaryStaticsOfPrimitiveStream;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class EX03_PrimitiveSummaryStaticsOfPrimitiveStream {
	public static void main(String[] args) {
		
		//#1. IntSummaryStatics
		IntSummaryStatistics iss = IntStream.of().summaryStatistics();
		System.out.println(iss.getCount());//요수의 수 (요소가 없는 경우 0)
		System.out.println(iss.getSum());//요수의 합 (요소가 없는 경우 0)
		System.out.println(iss.getMin());//요수의 최소값 (요소가 없는 경우 +Integer.MAX_VALUE)
		System.out.println(iss.getMax());//요수의 최대값 (요소가 없는 경우 -Integer.MAX_VALUE)
		System.out.println(iss.getAverage());//요수의 평균  (요소가 없는 경우0.0)

		//#2. DoubleSummaryStatics
		DoubleSummaryStatistics dss = DoubleStream.of(1.2, 3.4, 5.6).summaryStatistics();
		System.out.println(dss.getCount());//요수의 수
		System.out.println(dss.getSum());//요수의 합
		System.out.println(dss.getMin());//요수의 최소값
		System.out.println(dss.getMax());//요수의 최대값
		System.out.println(dss.getAverage());//요수의 평균

	}
}
