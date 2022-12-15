package chap9;

//JAVA API를 사용하여 다음과 같은 결과가 나오도록 빈칸을 채우십시오. 단, 빈칸은 반드시 적절한 메쏘드를 사용해서 채워져야 합니다.

/*---------------------------
실행 결과: 
1. 이름: Arnold Alois Schwarzenegger
2. 이름 (대문자): ARNOLD SCHWARZENEGGER
3. 이니셜:  AAS
4. First Name은 arnold이다. (대소문자 구분; T/F):  false
5. First Name은 arnold이다. (대소문자 미구분; T/F):  true
6. Last Name Schwarzenegger의 index 번호 6~14까지 문자열 : zenegger
7. Last Name Schwarzenegger에서 negger 문자열의 위치 : 8
---------------------------
*/

class StringTest {
  public static void main(String[] args) {
	String first = "Arnold";
	String middle = "Alois";
	String last = "Schwarzenegger";
	String initials;
	String firstInit, middleInit, lastInit;

	//firstInit =___________________;
	//middleInit = ___________________;
	//lastInit = ___________________;
	//initials = ___________________;

	System.out.print("1. 이름: "+ first + " " + middle + " " + last + "\n");
	//System.out.println(first + " " + middle + " " + last);
	System.out.print("2. 이름 (대문자): " + first.toUpperCase() + " " + last.toUpperCase() + "\n");
	//System.out.println(___________________ + " " + ___________________);
	System.out.print("3. 이니셜:  " + first.charAt(0) + middle.charAt(0) + last.charAt(0) + "\n");
	//System.out.println(initials);
			
	System.out.println("4. First Name은 arnold이다. (대소문자 구분; T/F):  " + first.equals("arnold") + "\n");
	System.out.println("5. First Name은 arnold이다. (대소문자 미구분; T/F):  " + first.equalsIgnoreCase("arnold") + "\n");
		
	System.out.println("6. Last Name " + last + "의 index 번호 6~14까지 문자열 : " +  last.substring(6,14) + "\n");
	System.out.println("7. Last Name " + last + "에서 negger 문자열의 위치 : " + last.indexOf("negger") + "\n");		
	}
}

