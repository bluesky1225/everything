import java.util.Scanner;

public class NumberTrianglePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출력할 라인 수 : ");
		
		input = sc.nextInt();
		
		int value = 0;		
		int max = input;		
		
		for(int i = 0; i < input; i++) {
			for(int j = 0; j < max; j++) {
				if(i == input-1) {
					System.out.print(value);
					value++;
				} else if(j == max - 1) {
					System.out.println(value);
					value++;
				} else if(max != input && j == input-1-i) {
					System.out.print(value);
					value++;
				} else {
					System.out.print(" ");
				}
					
					
				if(value == 10) value = 0;
			}
			max = max + 1;
		}
			
		sc.close();
	}	

}
