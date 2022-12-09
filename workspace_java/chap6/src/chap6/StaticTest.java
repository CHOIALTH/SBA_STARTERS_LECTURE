package chap6;
class Person{
	String name;
	int age;
	static String nation = "고구려";//Person 객체 공유. 1개의 메모리 할당. 모든 객체에 공통값
}
public class StaticTest {
	public static void main(String[] args) {
		System.out.println("모든 사람들의 국적은 " + Person.nation);
		Person p1 = new Person();
		p1.name = "지터";
		p1.age = 50;
		System.out.println(p1.name + " : "+ p1.age+ " : " + Person.nation);
		Person p2 = new Person();
		p2.name = "페티트";
		p2.age = 49;
		System.out.println(p2.name + " : "+ p2.age+ " : " + p2.nation);

	}

}
