package pack05_stream.sec01_CreateStreamObject.EX01_CollectionArrayToStream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*�÷��� �� �迭�κ��� Stream<E> ��ü ����*/

public class EX01_CollectionArrayToStream {
	public static void main(String[] args) throws IOException {
		
		//#1-1.�÷��� --> ��Ʈ��
		List<String> list = Arrays.asList("��","��","��");
		Stream<String> stream1 = list.stream();
		stream1.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#1-2.�÷��� --> ��Ʈ�� (������ ǥ��) : ����(chaining) ȣ��
		Arrays.asList("��","��","��").stream().forEach(s->System.out.print(s+" "));
		System.out.println();
		
		
		//#2-1. ��ü �迭 --> ��Ʈ��
		Integer[] array = {1,2,3,4,5};
		Stream<Integer> stream2 = Arrays.stream(array);
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#2-2. ��ü �迭 --> ��Ʈ�� (������ ǥ��) : ����(chaining) ȣ��
		Arrays.stream(array).forEach(s->System.out.print(s+" "));
		System.out.println();
	
	}
}
