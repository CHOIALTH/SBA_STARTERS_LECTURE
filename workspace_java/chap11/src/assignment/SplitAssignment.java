package assignment;

class Split{
	String url;

	/*
	 * public Split(String url) { this.url = url; }
	 */
	void split(String url) {
		// 메서드명 클래스명이랑 다른 소문자로 시작하는..관례다 by 태현쌤
		String theUrl = url.replace("http://", "");
		// http:// -> 공백
		String theUrl2 = theUrl.replaceAll("[.:/]","\n");
		// replaceAll 첫번째 인자로 정규식을 받는다.
		System.out.println(theUrl2);
	}
}

public class SplitAssignment {

	public static void main(String[] args) {
		Split s = new Split();
		s.split("http://www.kitri.re.kr:8080/java/test");
//		substring
	}
}
