package generic1;

class Apple{
	String origin;
	public Apple(String origin) { // 생성자
		this.origin = origin;
	}
}

class Paper{
	String size;
	public Paper(String size) {
		this.size = size;
	}
}
class Wine{
	String kind;
	public Wine(String kind) {
		this.kind = kind;
	}
}


class Box<T>{
	//클래스명 아니다. type의 약자 T. => T = type매개변수
	T contents;


	public T getContents() {
		return contents;
	}

	public void setContents(T contents) {
		this.contents = contents;
	}
	public Box(T contents) {
		this.contents = contents;
	}
	
}

public class NonGenericTest {

	public static void main(String[] args) {
		Apple a = new Apple("대구");
		Paper p = new Paper("A4");
		Box<Apple> aBox = new Box(a);
		Box<Paper> pBox = new Box(p);
		System.out.println(aBox.contents.origin);
		System.out.println(pBox.contents.size);
	}

}
