public class locationofpoint {
    // 사분면 상 점의 위치 구하기. (x,y)를 차례대로 담은 정수배열 dot이 매개변수로 주어진다
    // x&y > 0 (1사분면) || x<0, y>0 (2사분면) || x&y < 0 (3사분면) || x > 0 & y < 0 (4사분면)
        int[] dot = new int[2];
        int answer = 0;
    int solution(int[] dot){
       if(dot[0]>0 && dot[1] > 0){
           answer = 1;
       }
       else if(dot[0] < 0 && dot[1] > 0){
           answer = 2;
       }
       else if(dot[0] < 0 && dot[1] < 0){
           answer = 3;
       }
       else if(dot[0] > 0 && dot[1] < 0){
           answer = 4;
       }
        return answer;
    }
    // 다른 사람의 풀이
    /*
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] > 0)
            if(dot[1] > 0) answer = 1;
            else answer = 4;
        else
            if(dot[1] > 0) answer = 2;
            else answer = 3;

        return answer;
    }
    *
    *
    * */
}
