package annotation.member;

import org.springframework.stereotype.Component;
//MemberDTO dto = new MemberDTO(); dto.setId("")
@Component("dto")
public class MemberDTO {
	String id, pw, name, email, phone, address, indate;
	
	MemberDTO(){
		
	}
	
	MemberDTO(String id, String pw){//constructor-arg
		this.id= id;
		this.pw= pw;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {//<property
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
