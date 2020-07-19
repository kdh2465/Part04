package pack01_stream.sec03_TerminalOperations.EX07_AnyAllNoneMatching;

import java.util.stream.Stream;

public class EX07_AnyAllNoneMatching {
	public static void main(String[] args) {
		
		//#. Matching (anyMatch(), allMatch(), noneMatch()
		boolean anyMatch = Stream.of("¾È³ç","¹æ°¡","¶¯Å¥","°¡ÀÚ").anyMatch(s->s.contains("°¡"));
		boolean allMatch = Stream.of("¾È³ç","¹æ°¡","¶¯Å¥","°¡ÀÚ").allMatch(s->s.contains("°¡"));
		boolean noneMatch = Stream.of("¾È³ç","¹æ°¡","¶¯Å¥","°¡ÀÚ").noneMatch(s->s.contains("°¡"));
		System.out.println(anyMatch); //true
		System.out.println(allMatch); //false
		System.out.println(noneMatch);//false

	}
}
