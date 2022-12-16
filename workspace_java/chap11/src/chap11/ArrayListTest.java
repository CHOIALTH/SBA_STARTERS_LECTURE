package chap11;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(5);
		list.add("java");
		list.add(10);
		list.add(3.14);
		System.out.println(list.size());
		System.out.println(list.get(0));
	}

}
