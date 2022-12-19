package chap11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		int [] arr = {0,1,2,3,4}; // 1차원배열
		int [][] arr2 = {{1,2},{3,4,5},{6,7,8,9}}; // 2차원배열
		System.out.println(Arrays.toString(arr)); 
		System.out.println(Arrays.deepToString (arr2)); // 2차원배열 정상출력위해서 deepToString 활용
		
		int [] arr_copy = Arrays.copyOf(arr, 3); // 앞에서부터 3개추출 후 복사
		System.out.println("복사본==>" + Arrays.toString(arr_copy));
		System.out.println("비교==>" + Arrays.toString(arr));
		int [] arr_copy2 = Arrays.copyOfRange(arr, 3, 5);
		arr_copy2[0] = 20;
		System.out.println("복사본==>" + Arrays.toString(arr_copy2));
		
		int [] arr10 = {1,2,3,4,5};
		int [] arr20 = {1,2,3,4};
		System.out.println(Arrays.equals(arr10, arr20));
		
		int [] arrA = {100, 30, 45, 8, 99}; // 정렬전
		Arrays.sort(arrA); // 정렬
		System.out.println(Arrays.toString(arrA)); // 정렬 후
		
		List list = Arrays.asList(arrA);
		//타입 변환 - 배열 -> ArrayList (정적 / 동적 - 동일 / 다른 타입)
		// list.add(100); 
		// 컴파일 오류 X but 실행 오류 발생. List는 인터페이스타입이므로.. 따라서 변환전에 완성시키고 타입변환되게해야..
		
		ArrayList list2 = new ArrayList(5);
		list2.add("java");
		list2.add(10);
		list2.add(3.14);
		// 타입 변환 - ArrayList -> 배열
		Object [] list_arr = new Object[list2.size()];
		list2.toArray(list_arr);
		System.out.println(Arrays.toString(list_arr));
		
		
		
		
	}
	// String.join(":",String[])
}
