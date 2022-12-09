//회원관리 프로그램
package test;
class Member{
	String id, name;
	int  pw, age;
	void insert(String q, int w, String e, int r) {
		name = q; pw = w; name = e; age = r;
		System.out.printf("아이디 : %s\n 이름 : %s\n 나이 : %d\n 가입 완료되었습니다.\n", id, name, age);
	}
	void login(String a, int b) {
		if(a == "test" && b == 1234) {
			System.out.println("로그인되었습니다.\n");
			
		}else {System.out.println("로그인 정보를 확인하세요.\n");}
	}
	void setPassword(int c){
		pw = c;
		System.out.println("암호가 변경됐습니다\n");
	}
//	void getMyinfo()
	String logout() {
		System.out.println("로그아웃되었습니다\n");
		id = null; pw = -1; name = null; age = -1;
		return id;
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		Member mem = new Member();
		  mem.insert("test", 1234, "이자바", 25);
		  mem.login("test", 4321);
		  mem.login("test", 1234);
		  mem.setPassword(1111);
//		  mem.getMyInfo();
		  String id  = mem.logout();
		  if(id == null){
		   System.out.println("다시 로그인하셔야 합니다.");
		  }
	}

}
