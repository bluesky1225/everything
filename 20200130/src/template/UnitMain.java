package template;

public class UnitMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 템플릿 메소드 패턴이 적용된 클래스의 인스턴스 만들기
		// 변수는 인터페이스 이름을 사용하고 생성자는 클래스 이름을 이용하는 형태로 많이 작성
		Unit unit = new UnitImpl();
		unit.attack();
		unit.move();
		
		// List<String> list = new ArrayList<String>();
		
	}

}
