
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 일반적인 자바 객체 생성법
		// 사용자가 만든 클래스를 가지고 직접 생성자를 호출해서 인스턴스를 만들고 사용
		/*
		Temp temp = new Temp();
		temp.setNum(1);
		temp.setName("홍길동");
		System.out.println(temp);
		*/
		
		// Factory Method Pattern
		// 클래스의 인스턴스를 new를 직접 호출해서 생성하지 않고 다른 클래스의 메소드를 이용해서 생성하는 방식		
		Temp temp = TempFactory.create();
		temp.setNum(1);
		temp.setName("홍길동");
		System.out.println(temp);
		
		// Spring에서의 객체 생성법
		// 
		Temp temp1 = TempFactory2.create();
		temp1.setNum(2);
		temp1.setName("강감찬");		
		System.out.println(temp1);
		System.out.println(temp1.hashCode());
		
		Temp temp2 = TempFactory2.create();
		temp2.setNum(3);
		temp2.setName("을지문덕");	
		System.out.println(temp2);
		System.out.println(temp2.hashCode());
	}

}
