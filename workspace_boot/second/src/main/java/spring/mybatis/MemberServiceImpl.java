package spring.mybatis;

// dao-인터페이스(메소드이름) --- (스프링부트-SQLMAPPER) -- sql-mapping.xml (id) 동일
/*이전 방식이 Mapper 설정 파일(xml)에 있는 쿼리문의 ID를 직접 String 형태로 지정해서 사용했다면, 
 * Mapper 인터페이스를 사용한 방식은 인터페이스와 Mapper 설정 파일을 연동해두고 
 * 쿼리문의 ID와 동일한 메소드를 만들어둠으로써 
 * 해당 메소드를 호출하면 자동으로 쿼리문이 실행되도록 해주는 방식입니다.*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("memberservice")
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;

	@Override
	public List<MemberDTO> memberlist() {
		//dao.xxxxx()
		return dao.memberlist();
		
	}

	@Override
	public int membercount() {
		return dao.membercount();
	}

	@Override
	public MemberDTO onemember(String id) {
		return dao.onemember(id);
	}

	@Override
	public List<MemberDTO> paginglist(int[] limit) {
		return dao.paginglist(limit);
	}

	@Override
	public int insertmember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if(resultdto == null) {
			return dao.insertmember(dto);
		}
		return 0;
		
	}

	@Override
	public int updatemember(MemberDTO dto) {
		return dao.updatemember(dto);
	}

	@Override
	public int deletemember(String id) {
		return dao.deletemember(id);
	}

	@Override
	public List<MemberDTO> searchmember(HashMap map) {
		return dao.searchmember(map);
	}

	@Override
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return dao.addresssearch(addresslist);
	}

	@Override
	public List<MemberDTO> combination(MemberDTO dto) {
		return dao.combination(dto);
	}

	@Override
	public List<HashMap<String, String>> memberboard(String writer) {
		return dao.memberboard(writer);
	}

	@Override
	public int updatemember2(MemberDTO dto) {
		return dao.updatemember2(dto);
	}

}
