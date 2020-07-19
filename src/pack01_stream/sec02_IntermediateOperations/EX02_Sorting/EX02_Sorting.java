package pack01_stream.sec02_IntermediateOperations.EX02_Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Member1 implements Comparable<Member1> {
	private int age;
	private String name;
	public Member1(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Member1 o) {
		if (this.age < o.age)
			return -1;
		else if (this.age == o.age)
			return 0;
		else
			return 1;
	}
}

class Member2 {

	private int age;
	private String name;
	public Member2(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class EX02_Sorting {
	public static void main(String[] args) {
		
		//#1-1. sorting: sorted() : Integer, String
		//@오름차순
		Stream.of(1,5,4,2,8,7).sorted().forEach(s->System.out.print(s+" "));
		System.out.println();
		Stream.of("안녕","방가","감사","땡큐").sorted().forEach(s->System.out.print(s+" "));
		System.out.println();
		//@내림차순
		Stream.of(1,5,4,2,8,7).sorted(Comparator.reverseOrder()).forEach(s->System.out.print(s+" "));
		System.out.println();
		Stream.of("안녕","방가","감사","땡큐").sorted(Comparator.reverseOrder()).forEach(s->System.out.print(s+" "));
		System.out.println(); System.out.println();
		
		//#1-2. sorting: sorted() : Comparable을 상속한 임의의 클래스
		//@오름차순
		List<Member1> list1 = Arrays.asList(new Member1(20,"이름1"),new Member1(22,"이름2"),new Member1(18,"이름3"));
		//@오름차순
		list1.stream().sorted().forEach(s->System.out.println(s.getAge()+"-"+s.getName()+" "));
		//@내림차순
		list1.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s.getAge()+"-"+s.getName()+" "));

		
		//#2. sorting: sorted(Comparator<T> c)
		List<Member2> list2 = Arrays.asList(new Member2(20,"이름1"),new Member2(22,"이름2"),new Member2(18,"이름3"));
		//@오름차순
		list2.stream().sorted(new Comparator<Member2>() {
				@Override
				public int compare(Member2 o1, Member2 o2) {
				    if(o1.getAge()<o2.getAge()) return -1;
				    else if(o1.getAge()==o2.getAge()) return 0;
				    else return 1;
				}})
		.forEach(s->System.out.println(s.getAge()+"-"+s.getName()+" "));
		
		//@내림차순
		List<Member2> list3 = Arrays.asList(new Member2(20,"이름1"),new Member2(22,"이름2"),new Member2(18,"이름3"));		
		list3.stream().sorted(new Comparator<Member2>() {
				@Override
				public int compare(Member2 o1, Member2 o2) {
				    if(o1.getAge()<o2.getAge()) return 1;
				    else if(o1.getAge()==o2.getAge()) return 0;
				    else return -1;
				}})
		.forEach(s->System.out.println(s.getAge()+"-"+s.getName()+" "));

	}
}
