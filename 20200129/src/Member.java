
public class Member {
	private int num;
	private String name;
	private String birthday;
	private int gender;
	private String phone;
	private String email;
	private int workYear;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 테스트 할 때	 데이터를 빠르게 입력해서 확인하기 위해서 생성
	public Member(int num, String name, String birthday, int gender, String phone, String email, int workYear) {
		super();
		this.num = num;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.workYear = workYear;
	}

	// 접근자 메소드
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWorkYear() {
		return workYear;
	}

	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", phone="
				+ phone + ", email=" + email + ", workYear=" + workYear + "]";
	}

	
	
}
