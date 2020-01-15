package inheritance;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final int KNIGHT = 1;
		final int MAGE = 2;
		// TODO Auto-generated method stub
		Derived d = new Derived();
		d.disp();
		d.print();
		d.method();
		System.out.println(d.getNum());
		
		System.out.println();
		
		T t = new T();
		P p = new P();
		Z z = new Z();
		t.attack();
		p.attack();
		z.attack();
		
		Race r = new P();
		Race r2 = new T();
		Race r3 = new Z();
		r.attack();
		r2.attack();
		r3.attack();
		
		T t2 = (T)(new Race());
		
		
		
		System.out.print("유닛을 선택하세요---(1번: 레벨1 나이트    2번: 레벨2 메이지) ");
				
		Scanner sc = new Scanner(System.in);
		
		int unit = sc.nextInt();
		
		switch(unit) {
		case KNIGHT:
			Unit knight = new Knight();
			System.out.println("나이트를 선택하셨습니다.");
			break;
		case MAGE:
			Unit mage = new Mage(2, 0, 20, 10, 10);
			System.out.println("메이지를 선택하셨습니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		} 
		
		System.out.println("게임에 접속하였습니다.");
		
		
		Knight enemy = new Knight(2, 0, 20, 12, 12);
		while(true) {
			
			break;
			
		}
		
		
		
		
		
		
		//sc.close();
	}

}
