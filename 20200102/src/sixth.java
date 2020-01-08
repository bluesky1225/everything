import java.util.Scanner;

public class sixth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		String result = score >= 60 ? "합격":"불합격";
		System.out.println(result);
		
		if (score >= 60) {
			System.err.printf("%s", result);
		} else {
			System.err.printf("%s", result);
		}
		
		sc.close();
		
		
	}

}
