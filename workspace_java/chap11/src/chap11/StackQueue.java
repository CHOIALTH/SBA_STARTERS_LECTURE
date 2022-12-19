package chap11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

	public static void main(String[] args) {
		Stack st = new Stack(); // 동적 크기. 중복 저장, 마지막 저장 데이터를 우선조회
		st.push(1);
		st.push(2);
		st.push(3);
		
		  while(!st.isEmpty()) { 
			  System.out.println(st.pop());// 3. 조회 후 삭제
			  System.out.println(st.pop());// 2. System.out.println(st.pop()); 
			  System.out.println(st.pop());// 1. (이때부터 더이상 stack 없음)
			  }// while end
		 
		
		//System.out.println(st.pop()); // 3. 조회 후 삭제
		//System.out.println(st.pop()); // 2.
		//System.out.println(st.pop()); // 1. (이때부터 더이상 stack 없음)
		
		/*
		 * while(!st.empty()) { System.out.println(st.peek()); // 3(꼭대기)만 무한반복됨 }
		 */
		
		Queue qu = new LinkedList(); // 동적 크기. 중복 저장, 가장 처음 저장 데이터를 우선조회
		qu.offer(1);
		qu.offer(2);
		qu.offer(3);
		while(!qu.isEmpty()) {
			System.out.println(qu.poll());// 큐에서 데이터 조회 후 삭제
		}
	}

}
