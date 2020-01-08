import test.MethodClass;

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
		
		MethodClass mc = new MethodClass();
		int n = 10;
		int result = mc.fib(n); // n번째 피보나치 수열의 값을 구한다
		System.out.println("\n"+n+"번째 피보나치 수열의 값 : "+result);
		
	
		int n2 = 2;
		int result2 = mc.fib2(n2);
		System.out.println(n2+"번째 피보나치 수열의 값(재귀호출) : "+result2);
		
	}

}
