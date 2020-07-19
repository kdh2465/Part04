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
		
		//#1-1.컬렉션 --> 스트림
		List<String> list = Arrays.asList("가","나","다");
		Stream<String> stream1 = list.stream();
		stream1.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#1-2.컬렉션 --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Arrays.asList("가","나","다").stream().forEach(s->System.out.print(s+" "));
		System.out.println();
		
		
		//#2-1. 객체 배열 --> 스트림
		Integer[] array = {1,2,3,4,5};
		Stream<Integer> stream2 = Arrays.stream(array);
		stream2.forEach(s->System.out.print(s+" "));
		System.out.println();

		//#2-2. 객체 배열 --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Arrays.stream(array).forEach(s->System.out.print(s+" "));
		System.out.println();

				
		//참고사항. 현재의 작업 폴더 위치 알아내기 (default: 프로젝트 루트 위치)
		System.out.println(System.getProperty("user.dir"));
		
		//#3-1. 파일(UTF-8) --> 스트림
		Stream<String> stream3 = Files.lines(Paths.get("files/UTF-8.txt"), Charset.forName("UTF-8"));
		stream3.forEach(s->System.out.println(s));
		//#3-2. 파일(UTF-8) --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Files.lines(Paths.get("files/UTF-8.txt"), Charset.forName("UTF-8")).forEach(s->System.out.println(s));
		
		//#3-3. 파일(MS949) --> 스트림
		Stream<String> stream4 = Files.lines(Paths.get("files/MS949.txt"), Charset.forName("MS949"));
		stream4.forEach(s->System.out.println(s));
		//#3-4. 파일(MS949) --> 스트림 (동일한 표현) : 연결(chaining) 호출
		Files.lines(Paths.get("files/MS949.txt"), Charset.forName("MS949")).forEach(s->System.out.println(s));
		Files.lines(Paths.get("files/MS949.txt"), Charset.defaultCharset()).forEach(s->System.out.println(s));
				
	}
}
