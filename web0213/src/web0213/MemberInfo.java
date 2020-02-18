package web0213;

import java.util.Date;

public class MemberInfo {
	private String id;
	private String pw;
	private String name;
	private String address;
	private Date registerDate;
	private String email;
	public MemberInfo(String id, String pw, String name, String address, Date registerDate, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.registerDate = registerDate;
		this.email = email;
	}
	public MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", registerDate="
				+ registerDate + ", email=" + email + "]";
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
