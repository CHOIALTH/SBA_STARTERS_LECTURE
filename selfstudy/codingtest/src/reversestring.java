

public class reversestring {
    // 문자열 뒤집기
    // 문자열 my_string이 매개변수로 주어집니다. my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
    // 1 ≤ my_string의 길이 ≤ 1,000
        public String solution(String my_string) {
            // 기존 풀이시도
/*            String answer = "";
            // String[] arr = my_string.split("");
                // abc = 3
                // arr = [a, b, c}

                String[] arr = my_string.split("");
            for(int i = 0; i < arr.length ; i++){
                answer += arr[arr.length - 1];
            }// for end
            return answer;*/

            // 구글링으로 배열 역순 담기 검색 후 푼 것
            String answer = "";

            String[] arr = my_string.split("");
            String[] reverseArr = new String[arr.length];
            for(int i = arr.length - 1, j = 0; i >= 0; i--, j++ ){
                reverseArr[j] = arr[i];
                answer += reverseArr[j];
            }
            return answer;
        }
        /* 모범답안1
        import java.util.*;

            public String solution(String my_string) {
                StringBuilder sb = new StringBuilder();
                sb.append(my_string);
                sb.reverse();

                return sb.toString();
            }
        */
        /* 모범답안2
            public String solution(String my_string) {
                String answer = "";

            for(int i=my_string.length()-1; i>=0; i--){
                answer+=my_string.charAt(i);
            }
            // my_string.length()-1 : 배열은 0부터 시작하므로 마지막 원소를 표현하기 위함

            return answer;
            }
        */

}
