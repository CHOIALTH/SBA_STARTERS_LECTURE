package chap11;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("hong@email.com", 
		new String[] {"홍길동", "010-1234-1234", "031-1234-1234", "02-1234-1234"} );
		
		// key값(중복될 수 없는 성격인 것들)으로 이메일 입력
		map.put("hong@email.com", new String[] {"홍동이", "010-1234-1234", "031-1234-1234", "02-1234-1234"} );
		// 이 경우 새로운 인물 입력이 아니라, 홍길동->홍동이 이름 수정되는 것. 따라서 map.size에 변화를 주지 X
		map.put("lee@email.com", new String[] {"이자바", "2020-12-30"} );
		
		map.put("lee@sba.net", new String[] { "김새싹", "용산캠"} );
		System.out.println(map.size());
		
		Set keys = map.keySet();
		for(Object onekey : keys) {// 값 조회
			String[] value = (String[])(map.get(onekey));
			System.out.println("key = " + onekey);		
			for(String one : value) {
				System.out.println(one + " : ");
			}// for end
			System.out.println();
		}
		
		
		//조회
		//key들을 조회
		
		//Object o = map.get("hong@email.com");
		// key값 데이터를 넣어 조회해야.. 인덱스0번 1번 이런식의 조회는 불가능
		//System.out.println(o);
	}

}
