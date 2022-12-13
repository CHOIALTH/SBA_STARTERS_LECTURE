package chap7;

//import java.lang.Math;
//Math의 모든 변수(non-static& static 모두 포함)와 메서드 사용 허락
import static java.lang.Math.*;
//Math의 static변수와 메서드 사용 허락
import static java.lang.Integer.*;


public class StaticImportTest {

	public static void main(String[] args) {
		int ran = (int)(random()*100) + 1;
		//1~100 사이의 난수 발생
		//java.lang.Math.random();이지만, java.lang 굳이 import 안해도 사용가능하므로 생략 가능
		//import(line5) 할 시 Math. 생략 가능 
		System.out.println(ran);
		System.out.println(MAX_VALUE);
		//import(line7) 할 시 Integer. 생략 가능 

	}

}
