package pack02_stream.sec03_TerminalOperations.EX08_Iterating_forEach;

import java.util.stream.Stream;
//pull
public class EX08_Iterating_forEach {
	public static void main(String[] args) {
		
		//#. Iterating (forEach())
		Stream.of(1,2,3,4).forEach(s->System.out.println(s));
		Stream.of("?��?��", "베리", "감사").forEach(System.out::print);
		System.out.println();

		//cf. peek(..)?�� 중간?��?�� (최종?��?��?�� ?��?���? ?��?��?���? ?��?��) 
		Stream.of(1,2,3,4).peek(s->System.out.println(s));//?��?��?��?��
		Stream.of(1,2,3,4).peek(s->System.out.print(s+" ")).count();//?��?��?��

	}
}
