import java.util.*;
public class cutArray {
    // 정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때,
    // numbers의 num 1번 째 인덱스부터 num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
    public List<Integer> solution(int[] numbers, int num1, int num2) {
        List <Integer> arr = new ArrayList<>();
        for(int i = num1; i < num2; i++){
            arr.add(numbers[i]);
        }
        return arr;
    }
}
