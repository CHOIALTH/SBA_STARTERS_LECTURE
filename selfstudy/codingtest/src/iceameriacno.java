import java.util.ArrayList;
import java.util.List;

public class iceameriacno {
    public List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        if(money % 5500 == 0){
            answer.add(0, money / 5500 );
            answer.add(1,0);
        }
        else{
            answer.add(0, money/5500);
            answer.add(1, money - (money/5500) * 5500);
        }
        return answer;
    }
}

// 다른사람 답안1
//     public int[] solution(int money) {
//        return new int[] { money / 5500, money % 5500 };
//    }
// 나누는 값이 얼마든 결국엔 나머지 = 잔돈..이라는 아주 기본적인....

// 다른사람 답안2
//    public int[] solution(int money) {
//        int cnt = 0; // 커피잔 세는 개수
//        while(true) {
//  // 특정 조건 만족 전까지 무한 루프 돌림
//            if(money < 5500) {
//                break;
//            }
//            money -= 5500;
//            cnt++;
//        }
//        int[] answer = {cnt, money};
//        return answer;
//    }