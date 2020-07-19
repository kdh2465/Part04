package pack01_stream.sec03_TerminalOperations.EX07_AnyAllNoneMatching;

import java.util.stream.Stream;

/*스트림 요소 값의 매칭(Matching)여부 확인 : any/all/none+Match()*/

public class EX07_AnyAllNoneMatching {
	public static void main(String[] args) {
		
		//#. Matching (anyMatch(), allMatch(), noneMatch()
		boolean anyMatch = Stream.of("안녕","방가","땡큐","가자").anyMatch(s->s.contains("가"));
		boolean allMatch = Stream.of("안녕","방가","땡큐","가자").allMatch(s->s.contains("가"));
		boolean noneMatch = Stream.of("안녕","방가","땡큐","가자").noneMatch(s->s.contains("가"));
		System.out.println(anyMatch); //true
		System.out.println(allMatch); //false
		System.out.println(noneMatch);//false

	}
}
