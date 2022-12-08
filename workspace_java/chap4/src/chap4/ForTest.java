package chap4;

public class ForTest {

	public static void main(String[] args) {
		char star = '*';
		//1-20 난수
		int count = (int)(Math.random() * 20 ) + 1;
		//count만큼 한 줄 * 반복출력 개수. 1-20 난수
		int lines =(int)(Math.random() * 10) + 1;
		//출력줄 개수 개수. 1-10 난수
		
		System.out.println(lines + "줄에" + count + "만큼 출력합니다.");
//		for(int j = 1; j<= lines; j++) {
//			for(int i = 1; i <= count; i++) {
//				System.out.print(star);			
//			}// inner for end
//			System.out.print("\n");					
//		} //outer for end
//	}
	///////////////////////////////
	for(int j = 1; j<= lines; j++) {
		for(int i = 1; i <= count; i++) {
			System.out.print(star);			
		}// inner for end
		System.out.print("\n");					
	} //outer for end

}}

