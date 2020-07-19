package pack01_stream.sec03_TerminalOperations.EX03_PrimitiveSummaryStaticsOfPrimitiveStream;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class EX03_PrimitiveSummaryStaticsOfPrimitiveStream {
	public static void main(String[] args) {
		
		//#1. IntSummaryStatics
		IntSummaryStatistics iss = IntStream.of().summaryStatistics();
		System.out.println(iss.getCount());//����� �� (��Ұ� ���� ��� 0)
		System.out.println(iss.getSum());//����� �� (��Ұ� ���� ��� 0)
		System.out.println(iss.getMin());//����� �ּҰ� (��Ұ� ���� ��� +Integer.MAX_VALUE)
		System.out.println(iss.getMax());//����� �ִ밪 (��Ұ� ���� ��� -Integer.MAX_VALUE)
		System.out.println(iss.getAverage());//����� ���  (��Ұ� ���� ���0.0)

		//#2. DoubleSummaryStatics
		DoubleSummaryStatistics dss = DoubleStream.of(1.2, 3.4, 5.6).summaryStatistics();
		System.out.println(dss.getCount());//����� ��
		System.out.println(dss.getSum());//����� ��
		System.out.println(dss.getMin());//����� �ּҰ�
		System.out.println(dss.getMax());//����� �ִ밪
		System.out.println(dss.getAverage());//����� ���

	}
}
