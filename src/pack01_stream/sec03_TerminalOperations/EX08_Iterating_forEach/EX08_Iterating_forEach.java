package pack01_stream.sec03_TerminalOperations.EX08_Iterating_forEach;

import java.util.stream.Stream;

/*스트림 객체내의 모든 데이터를 반복적으로 꺼내와 작업 수행 : forEach()*/

public class EX08_Iterating_forEach {
	public static void main(String[] args) {
		
		//#. Iterating (forEach())
		Stream.of(1,2,3,4).forEach(s->System.out.println(s));
		Stream.of("땡큐", "베리", "감사").forEach(System.out::print);
		System.out.println();

		//cf. peek(..)는 중간작업 (최종작업이 없으면 동작하지 않음) 
		Stream.of(1,2,3,4).peek(s->System.out.println(s));//동작안함
		Stream.of(1,2,3,4).peek(s->System.out.print(s+" ")).count();//동작함

	}
}
