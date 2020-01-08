package constructor;

public class Member {
	
	private String id;
	private String pw = "4321";
	
	public Member() {
		super();
		this.id = "root";
		this.pw = "1234";
	}
	
	// 복사 메소드
	public Member clone() {
		// 인스턴스 생성
		Member other = new Member();
		// 데이터를 복제
		// 원래 참조형 데이터도 clone 해주어야 하지만 String은 예외
		other.id = this.id;
		other.pw = this.pw;
		
		// 복제된 데이터를 갖는 객체를 리턴
		return other;
	}
	
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
	
	
	
}
