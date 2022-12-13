package chap7;

public class CastingTest2 {
	void setParent(Parent, target{
		Parent p = target;
	}

	public static void main(String[] args) {
		Parent array [] = new Parent[3];
		//자동형변환 여러가지 타입 객체 --> 1개의 타입으로 통일..
		array[0] = new Parent();
		array[1] = new Child1(); //자동형변환
		array[2] = new Child2(); //자동형변환
		for(int i = 0; i<array.length; i++) {
			System.out.println(array[i].getClass().getName() + ":" + i + "번 인덱스 객체 : ");
			
			array[i].print(); //overriding 메서드 서로 다르다
			//Child2 객체인 경우 mc2() 호출
			if(array[i] instanceof Child2) {
				System.out.println("if문 : " + i);
				((Child2)array[i]).mc2();
			}
		}
	}

}
