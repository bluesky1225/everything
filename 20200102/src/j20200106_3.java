import java.util.Scanner;

public class j20200106_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = sc.nextInt();
		int a = 1, b = 1;
		int c = 0;
		System.out.println(max+"까지의 피보나치 수열");
		for(;;) {
			if(c == 0) {
				System.out.println(a+"\n"+b);
				c = a + b;
				continue;
			} 
			
			c = a + b;
			if(c>max) break;
			
			System.out.println(c);
			
			
			a = b;
			b = c;
			
			
		}
		
		sc.close();
	}
}
