package pack01_stream.sec01_CreateStreamObject.EX05_CreateParallelStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX05_CreateParallelStream {
	public static void main(String[] args) {
		//#1.�÷��� --> ����(Parallel) ��Ʈ��
		List<String> list = Arrays.asList("��","��","��");
		Stream<String> stream1 = list.parallelStream();
		System.out.println("���Ŀ���: "+stream1.isParallel());//���Ŀ���Ȯ��
		stream1.forEach(s->System.out.print(s+" "));
		//stream1.forEach(s->System.out.print(s+" " + ": "+Thread.currentThread().getName()+"\n")); //������ �ٲ�� ����
		System.out.println();
		
		//#2. ��ü �迭 -> Stream<T> -> ����(Parallel) ��Ʈ��
		Integer[] array = {1,2,3,4,5};
		Stream<Integer> stream2 = Arrays.stream(array).parallel();
		System.out.println("���Ŀ���: "+stream2.isParallel());//���Ŀ���Ȯ��
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();
		
		//#3. �⺻�ڷ����迭 -> xxxStream -> ����(Parallel) ��Ʈ�� (Long, Double ����)
		int[] intArray = {6,7,8,9,10};
		IntStream stream3 = Arrays.stream(intArray).parallel();
		System.out.println("���Ŀ���: "+stream3.isParallel());//���Ŀ���Ȯ��
		stream3.forEach(s->System.out.print(s+" "));
		System.out.println(); 
	}
}
