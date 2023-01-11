package memberservice;

public class MemberJanService implements MemberService {
	MemberDAO memberdao;
	PointDAO pointdao;
	public void registerMember() {
		boolean isLogin = memberdao.selectMember();
		if(!isLogin) {
			memberdao.insertMember();
			pointdao.setPoint(10000);
			System.out.println("");
		}
	}
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	public void setPointdao(PointDAO pointdao) {
		this.pointdao = pointdao;
	}
	
}
