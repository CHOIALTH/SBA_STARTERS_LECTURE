package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class MemberJanService implements MemberService {
	@Autowired
	MemberDAO memberdao;
	
	@Autowired
	PointDAO pointdao;
	public void registerMember() {
		boolean isLogin = memberdao.selectMember();
		if(!isLogin) {
			memberdao.insertMember();
			pointdao.setPoint(10000);
			System.out.println(pointdao.getPoint()+" 원이 적립되었습니다");
		}
	}
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	public void setPointdao(PointDAO pointdao) {
		this.pointdao = pointdao;
	}
	
}
