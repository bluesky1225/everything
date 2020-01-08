package board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int 전체보기 = 1;
		final int 상세보기 = 2;
		final int 삽입하기 = 3;
		final int 수정하기 = 4;
		final int 삭제하기 = 5;
		final int 종료 = 6;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.전체보기  2.상세보기  3.삽입하기  4.수정하기  5.삭제하기  6.종료");
			System.out.print("메뉴 입력 : ");
			
			int menu = sc.nextInt();
			
			switch(menu) {
			case 전체보기:
				System.out.println("전체보기 선택");
				break;
			case 상세보기:
				System.out.println("상세보기 선택");
				break;
			case 삽입하기:
				System.out.println("삽입하기 선택");
				break;
			case 수정하기:
				System.out.println("수정하기 선택");
				break;
			case 삭제하기:
				System.out.println("삭제하기 선택");
				break;
			case 종료:
				System.out.println("프로그램 종료");
				sc.close();
				System.exit(0); // 프로그램 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		
		
		}
		//sc.close();
	}

}
