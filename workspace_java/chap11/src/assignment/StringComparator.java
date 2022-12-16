package assignment;

class Compare{
	// isLength 값이 true 이면 문자열의 길이가 긴 문자열의 문자 개수를 리턴한다.
	// isLength 값이 false 이면 문자 ‘a’가 많은 문자열의 문자 개수를 리턴한다.
	String str1; 
	String str2;
	boolean isLength;
	Compare(String str1, String str2, boolean isLength) {
		this.str1 = str1;
		this.str2 = str2;		
		this.isLength = isLength;
	}
	int answer;
	void Compare(String str1, String str2, boolean isLength) {
		if(isLength = true) {
			if(str1.length() > str2.length()) {
				answer = str1.length();
			}
			else {
				answer = str2.length();
			}
		}
		else if (isLength = false) {
			for(int i = 0; i < )
			if(str1.length() > str2.length()) {
				answer = str1.length();
			}
			else {
				answer = str2.length();
			}
		}
	}
}
	

public class StringComparator {
	
	
	public static void main(String[] args) {
		Compare compare = new Compare(null, null, false);
		compare("javaprogram", "oracle", true);
		compare("javaprogram", "oracledatabase", false);
	}

}
