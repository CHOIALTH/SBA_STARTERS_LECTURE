import java.util.ArrayList;
import java.util.List;

public class lengthofarrayelement {
    // 문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.

    public List<Integer> solution(String[] strlist) {
        List<Integer> answer = new ArrayList<Integer>();
        /*int[] answer = {};*/
        for(int i = 0; i < strlist.length; i++){
            answer.add(strlist[i].length());
        }// for end
        return answer;
    }
}
// 다른사람 답안
/*
    public int[] solution(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
    Arrays.stream : 배열 스트림
    mapToInt : 중간연산자의 일종. stream을 IntStream으로 변환해주는 메서드
*/

// 다른사람 답안2
/*
 public ArrayList solution(String[] strlist) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(String str : strlist){
        // 이건 enhanced for문으로 strlist의 원소를 반복문 돌리기 위해 str로 잡음..
            answer.add(str.length());
        }

        return answer;
    }
*/
