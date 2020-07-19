package pack02_stream.sec03_TerminalOperations.EX08_Iterating_forEach;

import java.util.stream.Stream;
//pull
public class EX08_Iterating_forEach {
	public static void main(String[] args) {
		
		//#. Iterating (forEach())
		Stream.of(1,2,3,4).forEach(s->System.out.println(s));
		Stream.of("?•¡?", "ë² ë¦¬", "ê°ì‚¬").forEach(System.out::print);
		System.out.println();

		//cf. peek(..)?Š” ì¤‘ê°„?‘?—… (ìµœì¢…?‘?—…?´ ?—†?œ¼ë©? ?™?‘?•˜ì§? ?•Š?Œ) 
		Stream.of(1,2,3,4).peek(s->System.out.println(s));//?™?‘?•ˆ?•¨
		Stream.of(1,2,3,4).peek(s->System.out.print(s+" ")).count();//?™?‘?•¨

	}
}
