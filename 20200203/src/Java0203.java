import java.util.Scanner;

public class Java0203 {
	public static void main(String[] args) {
		System.out.println("Java로 exe 만들기");
		Scanner sc = new Scanner(System.in);
		System.out.println("아무키나 누르면 종료됩니다.");
		sc.hasNextLine();
		sc.close();
	}
}
