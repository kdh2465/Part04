package pack01_stream.sec01_CreateStreamObject.EX01_CollectionArrayFileToStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EX01_CollectionArrayFileToStream {
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

				
		//�������. ������ �۾� ���� ��ġ �˾Ƴ��� (default: ������Ʈ ��Ʈ ��ġ)
		System.out.println(System.getProperty("user.dir"));
		
		//#3-1. ����(UTF-8) --> ��Ʈ��
		Stream<String> stream3 = Files.lines(Paths.get("files/UTF-8.txt"), Charset.forName("UTF-8"));
		stream3.forEach(s->System.out.println(s));
		//#3-2. ����(UTF-8) --> ��Ʈ�� (������ ǥ��) : ����(chaining) ȣ��
		Files.lines(Paths.get("files/UTF-8.txt"), Charset.forName("UTF-8")).forEach(s->System.out.println(s));
		
		//#3-3. ����(MS949) --> ��Ʈ��
		Stream<String> stream4 = Files.lines(Paths.get("files/MS949.txt"), Charset.forName("MS949"));
		stream4.forEach(s->System.out.println(s));
		//#3-4. ����(MS949) --> ��Ʈ�� (������ ǥ��) : ����(chaining) ȣ��
		Files.lines(Paths.get("files/MS949.txt"), Charset.forName("MS949")).forEach(s->System.out.println(s));
		Files.lines(Paths.get("files/MS949.txt"), Charset.defaultCharset()).forEach(s->System.out.println(s));
				
	}
}
