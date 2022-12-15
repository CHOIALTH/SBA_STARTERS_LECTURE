package chap9;

public class HashCodeTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("hashtest");
		MyObject o2 = new MyObject("hashtest");
		String s1 = new String("hashtest");
		String s2 = new String("hashtest");
		
		System.out.println("o1의 해쉬값 = " + o1.hashCode());
		System.out.println("o2의 해쉬값 = " + o2.hashCode());
		// hashcode overriding
		System.out.println("s1의 해쉬값 = " + s1.hashCode());
		System.out.println("s2의 해쉬값 = " + s2.hashCode());
		// String overriding 되기 전 값
		System.out.println(System.identityHashCode(s1));  
		System.out.println(System.identityHashCode(s2));  
	}

}
