package spring.mybatis;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext  factory = 
				new ClassPathXmlApplicationContext("spring/mybatis/spring-mybatis.xml");
		
		/*String names[]= factory.getBeanDefinitionNames();
		System.out.println("=============================");
		for(String n :names) {
			System.out.println(n);//@ 3개, data연결객체 3개
		}
		System.out.println("=============================");
		*/
			
		MemberService service = (MemberService)factory.getBean("service");

		
		//////////////////////////////////////////////////////////////////
		//test1 - 리스트 조회
		List<MemberDTO> list = service.memberlist();
		for(MemberDTO m : list) {
			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());
		}
		//test2 - 조회 int 
		//System.out.println("전체 회원수 = " + service.membercount());
		//test3 - 조회 (입력파라미터 존재, 결과 MemberDTO )
		/*MemberDTO m = service.onemember("maria11111");
		if(m != null) {
			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());
		}
		*/
		//test4 - 페이징처리 리스트 조회
		/*int[] limit = {0, 3};
		List<MemberDTO> list = service.paginglist(limit);
		for(MemberDTO m : list) {
			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName());
		}*/
		
		//test5
		/*MemberDTO insertdto = new MemberDTO();
		insertdto.setId("mybatis");
		insertdto.setPw("mybatis");
		insertdto.setName("박대한");
		insertdto.setPhone("01012345678");
		insertdto.setEmail("A@b.com");
		insertdto.setAddress("용산시 용산구");
		service.insertmember(insertdto);
		*/
		//test6
		// id=mybatis , name="박한국" phone=01087654321 이메일=mybqatis@b.com 수정
		//updatemember sql 실행
		/*MemberDTO updatedto = new MemberDTO();
		updatedto.setId("mybatis");
		//updatedto.setPw("mybatis");
		updatedto.setName("박한국");
		updatedto.setPhone("01087654321");
		updatedto.setEmail("mybqatis@b.com");
		//updatedto.setAddress("용산시 용산구");
		service.updatemember(updatedto);//factory.openSession(true)
		
		//확인
		int[] limit = {0, 3};
		List<MemberDTO> list = service.paginglist(limit);
		for(MemberDTO m : list) {
			System.out.println(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getEmail()+":"+m.getPhone());
		}
		*/
		
		//test7 
		//id mybatis 삭제
		//int row = service.deletemember("mybatis");

		
		//test8-map
		/*HashMap<String, String> map = new HashMap();
		map.put("colname", "indate");//${colname}
		map.put("colvalue", "2023%");//#{colvalue}
		// select * from member where ${colname} like #{colvalue}
		List<MemberDTO> searchlist = service.searchmember(map);
		for(MemberDTO m : searchlist) {
			System.out.println
			(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getEmail()
			+":"+m.getPhone()+":"+m.getIndate());
		
		}*/
		//test9
		/*ArrayList<String> addresslist = new ArrayList();
		addresslist.add("서울시 용산구");
		addresslist.add("제주시 용산구");
		addresslist.add("서울시 중구");
		List<MemberDTO> resultlist = service.addresssearch(addresslist);
		for(MemberDTO m : resultlist) {
			System.out.println
			(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getEmail()
			+":"+m.getPhone()+":"+m.getAddress());
		}*/
		
		//test10 - 조합+동적조건절
		/*MemberDTO dto = new MemberDTO();
		dto.setName("김상형");
		//dto.setEmail("mybqatis@b.com");
		List<MemberDTO> resultlist=service.combination(dto);
		for(MemberDTO m : resultlist) {
			System.out.println
			(m.getId()+":"+m.getPw()+":"+m.getName()+":"+m.getEmail()
			+":"+m.getPhone()+":"+m.getAddress());
		}*/
		
		//test11 - join시 resultmap
		/*List<HashMap<String, String>> boardlist = service.memberboard("maria");
		for(HashMap map : boardlist) {
			Set<String> keys = map.keySet();
			for(String s:keys) {
				System.out.println(s + " : " + map.get(s));
			}
		}*/
		
		//TEST12
		
		/*1. id 회원이 작성 글이 있는지 검사
		 * 2. 글이 있으면 사용자 탈퇴전에 글도 삭제하시겠습니까? y/n
		 * 3-1. 사용자 탈퇴처리
		 * 3-2. 사용자 탈퇴취소
		 * */
		/*
		maria 글 3개 
		테스트후
		INSERT INTO member VALUES
('maria', 'maria', '김상형', '01099221234', 'sang@kil.net','제주시 애월동','2023-01-03 12:29:19');
		실행하기
		mybatis 글 없음
		테스트후
		test5,6다시 실행하기
		*/
		
/*		List<HashMap<String,String>> boardlist = dao.memberboard("mybatis");
		if(boardlist.get(0).get("title").equals("글없음")) {
			System.out.println("작성하신 글이 없어요");
			service.deletemember("mybatis");
		}
		else {
			Scanner sc = new Scanner(System.in);
			System.out.print ("사용자 탈퇴전에 글도 삭제하시겠습니까? ");
			String reply = sc.next();
			if(reply.equalsIgnoreCase("y")) {
				service.deletemember("mybatis");
				System.out.println("탈퇴 처리되셨습니다.");
			}
			else {
				System.out.println("탈퇴 취소되셨습니다.");
			}
		}*/
	}

}








