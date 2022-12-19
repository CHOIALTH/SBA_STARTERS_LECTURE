package chap11;

import java.util.Arrays;

public class ComparatorTest {

	public static void main(String[] args) {
		String[] animals = {"1-cat", ":dog", "Bear", "lion" , "동물"};
		// 사전순서 :  숫자 -> 특수문자 일부 -> 대문자 -> 소문자 -> 한글
		Arrays.sort(animals);
		//Arrays.sort(animals, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(animals));
		
		class MyComparator implements Comparator{
			@Override
			public int compare(Object o1, Object o2) {
				if(!(o1 instanceof String && o2 instanceof String ))
					return = -1;
			}
		}// 내림차순
	}
}
