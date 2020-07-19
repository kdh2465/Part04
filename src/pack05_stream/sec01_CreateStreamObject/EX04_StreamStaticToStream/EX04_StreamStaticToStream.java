package pack05_stream.sec01_CreateStreamObject.EX04_StreamStaticToStream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*Stream Ŭ������ �����޼��带 Ȱ���� Stream<E> ��ü ����*/

public class EX04_StreamStaticToStream {
	public static void main(String[] args) {
		
		//#1.�� Stream ��ü ���� empty()
		Stream<String> stream1 = Stream.<String>empty();
		stream1.forEach(s->System.out.print(s+" "));
		
		//#2.builder(), add(), build�� �̿��Ͽ� �����͸� ���� steam �����
		Stream<String> stream2 = Stream.<String>builder().add("��ť").add("����").add("����").build();
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#3. T... values�� ���·� �Ѱ��� �����͸� ������ Stream ��ü ���� of()
		Stream<String> stream3 = Stream.of("�ȳ�", "�氡", "�߰�");
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
		
		//#4.������ ��(�ʱⰪ)�� ������ Stream��ü ���� generate()
		Stream<Integer> stream7 = Stream.generate(()->-1).limit(5);
		stream7.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#5.�ʱⰪ���� �������� �����ϴ� Stream ��ü ���� iterate()
		Stream<Integer> stream8 = Stream.iterate(0, n->(n+1)).limit(5);
		stream8.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#6. �� ���� ��Ʈ�� �����Ͽ� ���ο� Stream ��ü ���� concat()
		Stream<String> stream9_1 = Stream.of("�ȳ�", "�氡", "�߰�");
		Stream<String> stream9_2 = Stream.of("��ť", "����", "����");
		Stream<String> stream9 = Stream.concat(stream9_1, stream9_2);
		stream9.forEach(s->System.out.print(s+" "));
		
	}
}
