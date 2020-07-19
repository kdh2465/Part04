package pack01_stream.sec03_TerminalOperations.EX07_AnyAllNoneMatching;

import java.util.stream.Stream;

/*��Ʈ�� ��� ���� ��Ī(Matching)���� Ȯ�� : any/all/none+Match()*/

public class EX07_AnyAllNoneMatching {
	public static void main(String[] args) {
		
		//#. Matching (anyMatch(), allMatch(), noneMatch()
		boolean anyMatch = Stream.of("�ȳ�","�氡","��ť","����").anyMatch(s->s.contains("��"));
		boolean allMatch = Stream.of("�ȳ�","�氡","��ť","����").allMatch(s->s.contains("��"));
		boolean noneMatch = Stream.of("�ȳ�","�氡","��ť","����").noneMatch(s->s.contains("��"));
		System.out.println(anyMatch); //true
		System.out.println(allMatch); //false
		System.out.println(noneMatch);//false

	}
}
