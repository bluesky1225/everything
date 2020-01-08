import java.util.Scanner;

public class Eighth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("메뉴를 입력하세요(한식-1, 중식-2, 분식-3, 일식-이외) : ");
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1:
				System.out.println("한식입니다.");
				break;
			case 2:
				System.out.println("중식입니다.");
				break;
			case 3:
				System.out.println("분식입니다.");
				break;
			default:
				System.out.println("일식입니다.");
		}
		
		sc.close();
	}

}
