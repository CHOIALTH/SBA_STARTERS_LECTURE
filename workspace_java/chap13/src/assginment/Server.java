package assginment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

//1개 서버 - 다수개 클라이언트 요청 - 처리
public class Server {
	static boolean write = false;
public static void main(String[] args) {
	LoginClient c1 = new LoginClient("java", "java");
	LoginClient c2 = new LoginClient("java", "1234");
	RegisterClient c3 = new RegisterClient(new Date());
	BoardClient c4 = new BoardClient();
	
	  c1.start(); 
	  c2.start(); 
	  c3.start(); 
	  c4.start();
	 
	  // 이하 리턴타입, 매개변수 없는 람다식 활용
	  Thread c5 = new Thread(()->{System.out.println("람다스레드");});
	  c5.start();
	  
	  // 이하 리턴타입, 매개변수 있는 람다식 활용. 날짜포맷 매개변수 전달하면 날짜완성 형태
	  Function<String, String> mydate = str -> new SimpleDateFormat(str).format(new Date());
	  
	  
}
}
//1.멀티스레드클래스 정의
//2.생성자 정의/ 필드변수 정의
class LoginClient extends Thread{
	// Thread 클래스 상속받음
	/*main 전달 id=java, pw=java 
	 * 로그인아이디xxxx를 입력받습니다
	 * 로그인암호를 확인합니다
	 * pw=java이면 로그인암호 맞습니다
	 * 아니면 로그인암호 올바르지 않습니다
	 * */
	String id, pw;
	LoginClient(String id, String pw){
		super();
		this.id = id;
		this.pw = pw;
	}
	public void run() {
		// run 메서드 오버라이딩
		System.out.printf("로그인아이디%s를 입력받습니다\n로그인압호를 확인합니다\n",id);
		if(pw.equals("java")) {
			System.out.println("로그인암호 맞습니다");
		}else {System.out.println("로그인암호 올바르지 않습니다");}
	}
}
class RegisterClient extends Thread{
	// Thread 클래스 상속받음
	/*main 전달 Date 객체 
	 * xxxx년도 xx월 xx일에 회원가입요청합니다
	 * 회원가입요청 처리중입니다
	 * 3초 일시 중지
     * 회원가입요청 처리완료입니다
	 * */
	String datestr;
	RegisterClient(Date date){
		datestr = new SimpleDateFormat("yyyy년도 MM월 dd일").format(date);
	}
	@Override
	public void run() {
		System.out.println(datestr + "에 회원가입요청합니다\n회원가입요청 처리중입니다");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		System.out.println("회원가입요청 처리완료입니다");
	}
}
class BoardClient extends Thread{
	// Thread 클래스 상속받음
	/*5번 반복 : 0.5초마다 게시물 x번작성합니다 */
	@Override // modifier 같거나 더 넓고 리턴타입 이름 매개변수 일치해야함.
	// 부모클래스 throws 예외보다 더 많은 다른 종류 예외 throws 불가함.
	public void run() {
		for(int i = 1; i <= 5; i++) {
			System.out.printf("게시물 %d번 작성합니다\n",i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // for end
	}
}

/*실행예시
 로그인아이디java를 입력받습니다
로그인암호를 확인합니다
게시물 1 번작성합니다
로그인아이디java를 입력받습니다
로그인암호를 확인합니다
로그인암호 올바르지 않습니다
2022년도 12월 20일에 회원가입요청받았습니다
게시물 2 번작성합니다
로그인암호 맞습니다
게시물 3 번작성합니다
회원가입요청 처리중입니다
게시물 4 번작성합니다
게시물 5 번작성합니다
게시물 5개 작성 종료합니다.
회원가입요청 처리완료입니다
 * */


