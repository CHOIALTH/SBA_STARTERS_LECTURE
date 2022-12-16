1.
StringComparator 클래스의 
int compare(String str1, String str2, boolean isLength) 
메소드를 완성하십시오. 

compare 메소드는 String 타입의 문자열을 2개 입력받아 
조건에 맞는 문자열의 문자 개수를 리턴합니다. 
isLength 값이 true 이면 문자열의 길이가 긴 문자열의 
문자 개수를 리턴하고, false 이면 문자‘a’의 개수가 
많은 문자열의 문자 개수를 리턴합니다. 


int compare(String str1, String str2, boolean isLength)
-isLength 값이 true 이면 문자열의 길이가 긴 문자열의 문자 개수를 리턴한다.
-isLength 값이 false 이면 문자 ‘a’가 많은 문자열의 문자 개수를 리턴한다.


<<처리 결과>>
예) compare(“javaprogram”, “oracle”, true)   ☞  11   
예) compare(“javaprogram”, “oracledatabase”, false)  ☞  14

주의 사항 :
１)	테스트 목적으로 스스로 main을 구현할 수 있습니다. 
２)	주어진 메서드의 signature는 변경하지 않습니다.


2. url을 입력받아서 아래 출력결과처럼 분리 출력
String url = 
"http://www.kitri.re.kr:8080/java/test";

--출력결과---
www
kitri
re
kr
8080
java
test


3. 
main
String data = "지금 저는 ㅋㅋㅋ 수업중입니다. 정말요? 과제물도 ㅎㅎㅎ 하고 있구요.";
String delResult2 = deleteChar(data, new String[]{".", "ㅋ", "ㅎ","?", " "});
System.out.println("===> " + delResult2);
===> 지금저는수업중입니다정말요과제물도하고있구요

deleteChar 구현메소드






