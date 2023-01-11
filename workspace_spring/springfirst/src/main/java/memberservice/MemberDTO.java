package memberservice;

public class MemberDTO {
	String id, pw, name, email, phone, address, indate;
	MemberDTO(){
		
	}// 기본생성자
	
	
	MemberDTO(String id, String pw){
		this.id = id;
		this.pw = pw;
	} // 생성자 생성 (기본생성자가 없어지고 방금 만든 생성자가 남는다. 다만 위처럼 기본생성자 명시하면 안없어짐)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}
	
}
