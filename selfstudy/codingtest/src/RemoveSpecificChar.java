import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class RemoveSpecificChar {
    // 문자열 my_string과 문자 letter이 매개변수로 주어집니다. my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
    // 틀렸음..왤케 어렵냐..
/*    public String solution(String my_string, String letter) {
        String answer = "";
        List <String> arr = new ArrayList<String>();

        for(int i = 0; i < my_string.length(); i++ ){
            arr.add(i, my_string.split("")[i]);
            for(int j = 0; j < arr.size(); j++ ){
                if(arr.get(j).equals(letter)){
                    arr.remove(j);
                    answer = String.join("",arr);
                }

            }
        }


        return answer;
    }*/
    // 모범답안1
    public String solution(String my_string, String letter) {
        String answer = "";
        for(char c : letter.toCharArray()){
            answer = my_string.replace(String.valueOf(c),"");
        }
        return answer;
    }
    // 모범답안2
/*    public String solution(String my_string, String letter) {
        String answer = "";

        answer = my_string.replace(letter, "");

        return answer;
    }*/
}


