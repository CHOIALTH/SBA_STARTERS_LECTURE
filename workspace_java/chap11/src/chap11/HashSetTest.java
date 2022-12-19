package chap11;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		// 22명 성적 저장 - ArrayList (성적 중복점수 있을 수 O)
		// 100 사이의 소수 저장, 로또번호생성(6개) - HashSet(중복값 X)
		HashSet set = new HashSet(5);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(5);// 중복저장X(무시해버린다)
		System.out.println(set.size());
		System.out.println("=========================");
		
		HashSet lottoSet = new HashSet(6);
		while(true) {
			// 무한루프를 돌린다
			// lottoset에 ran 변수 저장
			// lottoset 크기 6개이면 반복문 stop
			int ran = (int)(Math.random()*45)+ 1;
			
			System.out.println(ran);
			lottoSet.add(ran);
			if(lottoSet.size() == 6) {
				break;
			}
		}
		
	}

}
