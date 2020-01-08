package test;

public class j20200108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Student 클래스의 인스턴스 생성
		Student s = new Student();
		
		String name = "홍길동";
		int num = 1;
		String major = "컴퓨터공학";
		
		s.setNum(num++);
		s.setName(name);
		s.setMajor(major);
		
		System.out.println("| 번호 : "+s.getNum()+" | 이름 : "+s.getName()+" | 전공 : "+s.getMajor()+" |");
	}

}
