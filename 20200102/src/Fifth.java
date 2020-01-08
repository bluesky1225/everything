import java.util.Scanner;

public class Fifth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine(); // 값 입력
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // 값 입력
				
		System.out.printf("%s님 안녕하세요", name);
		System.out.println("올해 "+age+"세가 되셨습니다.");
	}

}
