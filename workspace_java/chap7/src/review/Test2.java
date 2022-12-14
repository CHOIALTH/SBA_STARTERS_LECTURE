package review;

class Information{
	String id;
	String name;
	Information(String id, String name){
		this.id = id;
		this.name = name;
	}
	String print() {
		return id+":"+name;
	}
}

class InformationList{
	Information array [] ;
	int length; //멤버변수
	int count;
	InformationList(String length){
		this.length = Integer.parseint(length);
		array = new Information(this.length);
	}
	void add(Information inform) { //6번
		if(count >= array.length) {
			return; //메서드 중단
		}
		array[count++] = inform;
	}
	void read() {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i].id + ":" + array[i].name);
		}
	}
}
class Board extends Information{
	//Board(){super();}
	//String id; //게시물코드
	//String name; //게시물이름
	String contents; //게시물내용
	int viewcount; //조회수
	//new Board("1", "게시물1", "현재 조회수 10입니다." "10"
	Board(String id, String name, String contents, int viewcount) {
		super(id, name); // Information(String id, String name)
		this.contents = contents;
		this.viewcount =viewcount;
	}
	@Override
	String print() {
		return super.print() + ":" + contents + ":" + viewcount;
	}
	
}
class Product extends Information{
	super(id,name);
	//Product(){super();}
	//String id; //상품코드
	//String name; //상품이름
	int price; //상품가격
}
class Member extends Information{
	String email, phone;
	public Member() {
		super(id,name);
		this.email = email;
		this.phone = phone;	
	}
}
public class Test2 {

	public static void main(String[] args) {
		InformationList list = new InformationList(args[0]);//
		list.add(new Board("1","게시물1","현재 조회수 10입니다",10));
		list.add(new Product("100", "웅진비데", 300000));
		list.add(new Member("hong","홍길동","hong@a.com","010-222-2222"));
		list.add(new Board("2","게시물2","새로운 게시물 추가합니다", 0));
		list.add(new Product("200", "웅진정수기", 1000000));
		list.add(new Member("lee","이철수","chul@b.com","010-333-3333"));
		list.read();
	}

}
