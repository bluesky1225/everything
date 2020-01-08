import java.util.Scanner;

public class seventh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		if(score < 100 && score >= 90) {
			System.out.println("A");
		} else if(score < 90 && score >= 80) {
			System.out.println("B");
		} else if(score < 80 && score >= 70) {
			System.out.println("C");			
		} else if(score < 70 && score >= 60) {
			System.out.println("D");	
		} else if(score < 60) {
			System.out.println("F");
		} else {
			System.out.println("비정상적인 값입니다.");			
		}
		
		sc.close();
		
	}

}
