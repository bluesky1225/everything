import java.util.Scanner;

public class j20200107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 선택정렬
		int temp = 0;
		int[] numbers = {23, 1, 77, 33, 2, 6, 5};
		int count = numbers.length;
		
		for(int i = 0; i < count-1; i++) {
			for(int j = i+1; j < count; j++) {				
				// 오름차순
				if(numbers[i] > numbers[j]) {
					// swap
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}			
		}
		System.out.print("선택정렬(오름차순) : ");		
		for(int i : numbers)
			System.out.print(i + "\t");
		System.out.println();
		
		for(int i = 0; i < count-1; i++) {
			for(int j = i+1; j < count; j++) {				
				// 내림차순
				if(numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}			
		}
		System.out.print("선택정렬(내림차순) : ");
		for(int i : numbers)
			System.out.print(i + "\t");
		System.out.println();
		
		//int swapCnt = 0;
		// 버블정렬
		for(int i = 0; i < count-1; i++) {
			boolean flag = false;
			for(int j = 0; j < count-i-1; j++) {
				if(numbers[j] > numbers[j+1]) {
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;	
					//swapCnt++;
					flag = true;
				}
			}
			if(flag==false) break;
			/*if(swapCnt == 0) {
				break;
			} else {
				swapCnt = 0;
			}*/
		}
		System.out.print("버블정렬(오름차순) : ");
		for(int i : numbers)
			System.out.print(i + "\t");
		System.out.println();
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 수를 입력하세요 : ");
		int input = sc.nextInt();
		
		for(int i = 0; i < count; i++) {
			if(numbers[i]==input) {
				System.out.println("입력값은 "+i+"번째 인덱스입니다.");
			}
		}
		
		sc.close();
	}

	
	
}
