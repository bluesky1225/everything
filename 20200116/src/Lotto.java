import java.util.Scanner;
import java.util.*;
public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int cnt=1;
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int input=0;
		label1:while(cnt<7) {
			System.out.print("로또에 사용할 숫자를 입력하세요"+cnt+": ");
			
			try {
				input = sc.nextInt();
				if(input <1 || input > 45) {
					System.out.println("1~45 사이의 숫자를 입력해주세요.");
					continue;
				}
			} catch(Exception e) {
				System.out.println("값이 잘못되었습니다. 프로그램을 종료합니다.");
				break;
			}
			
			for(Integer data:ar) {
				if(data == input) {
					System.out.println("값이 중복됩니다");
					continue label1;
				}					
			}
			
			cnt+=1;
			ar.add(input);		
		}
		
		ar.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		System.out.println();
		
		for(Integer temp : ar)
			System.out.print(temp + "\t");
		
		sc.close();
	}

}
