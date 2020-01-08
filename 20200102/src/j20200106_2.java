import java.util.Scanner;

public class j20200106_2 {
	public static void main(String[] args) {
		String[] strAr = {"발렌수엘라", "클레멘테", "루게릭"};
		
		System.out.println(strAr); // 참조한 해쉬코드 출력
		
		System.out.println(strAr[0]);
	
		// 배열명.length는 배열의 데이터개수를 정수로 리턴
		// 아래와 같이 사용하지 말고 미리 변수 = strAr.length로 저장해두고 아래에서는 변수를 가지고 사용하자
		// 매번 배열.length를 사용하면 
		for(int i = 0; i < strAr.length; i++)
			System.out.println(strAr[i]);
		
		String [] homerunHitters = new String[3];
		
		homerunHitters[0] = "김봉연";
		homerunHitters[1] = "이만수";
		homerunHitters[2] = "김성한";
		
		// indexOutOfBoundsException 에러 발생
		//homerunHitters[3] = "김성래";
		
		int[][] test = new int[2][];
		test[0] = new int[3];
		test[1] = new int[2];
		test[0][0] = 1; 
		test[0][1] = 2; 
		test[0][2] = 3; 
		test[1][0] = 4; 
		test[1][1] = 5; 
		
		int cnt = test.length;
		
		System.out.println(test);
		System.out.println(test[0]);
		System.out.println(test[1]);
		
		// 인덱스를 통한 접근
		for(int i = 0; i < cnt; i++) {
			int cnt2 = test[i].length;
			for(int j = 0; j < cnt2; j++) {
				System.out.println("test["+i+"]["+j+"] : "+test[i][j]);
			}
		}
		
		// 빠른 열거(iterator)를 통한 접근
		for(int [] i : test) {
			for(int j : i) {
				System.out.println(j);
			}
		}
		
		String[][] names = {{"kim", "lee"}, {"park", "choi"}, {"shin", "baek"}};
		int tot = names.length*names[0].length;
		int colc = names[0].length;
		// 2차원 배열중에서 모든 행의 열 개수가 동일하다면 하나의 반복문으로 모든 데이터에 접근 가능
		for(int i = 0; i < tot; i++)
			System.out.print(names[i/colc][i%colc] + "\n");
		
		
		Scanner sc = new Scanner(System.in);
		int count = 6;
		int[] numbers = new int[count];
		int temp;
		boolean flag=false;
		
		for(int i = 0; i < count; i++) {
		//here : for(int i = 0; i < count; i++) { // 이렇게 해도 되지만 가급적 레이블 사용은 피하자
			System.out.print("1-45 사이의 정수를 입력하시오 : ");
			//numbers[i] = sc.nextInt(); 아래서 비교해야하므로 참조형은 부적절
			temp = sc.nextInt();
			
			// 값의 범위 유효성 검사
			if (temp < 1 || temp > 45) {
				System.out.println("다시 입력하세요.");				
				i--;
				continue;				
			}
			
			// 중복X 유효성검사
			if(i>0) {
				flag = false;
				for(int j = 0; j < i; j++) {
					if(temp == numbers[j]) {
						flag = true;
						System.out.println("값이 중복됩니다. 다시 입력하세요.");
						//i--;
						//continue here; // 레이블을 사용해서 이렇게 해도 된다
						break;
					}
				}
				
				if(flag==true) {
					i--;
					continue;
				}
			}
			
			numbers[i] = temp;
		}
		
		sc.close();
		
		/////////// 기술 통계 ////////////
		// 합계, 평균(실수로 구한 뒤에 소수점에서 반 올림)
		int total = 0;
		for(int i : numbers)
			total+=i;
		System.out.println("합계 : "+total);
		double avg = total/(double)count;
		avg = (int)(avg+0.5);
		System.out.println("평균 : "+avg);
		
		// 조건에 맞는 데이터 개수
		int dataCnt = 0;
		for(int i : numbers)
			if(i > 30) dataCnt++;
		System.out.println("30이 넘는 데이터 개수 : "+dataCnt);
		
		// 최대값(값의 범위를 모르면 첫번째 입력값으로 설정하는 것이 무난)
		int max = 0;
		for(int i : numbers) {
			if(i > max) max = i;
		}
		System.out.println("최대값 : "+max);
		
		// 최소값(값의 범위를 모르면 첫번째 입력값으로 설정하는 것이 무난)
		int min = 45;
		for(int i : numbers) {
			if(i < min) min = i;
		}
		System.out.println("최소값 : "+min);
		
		// 30에서 가장 가까운 수 찾기
		int a = 30; // 기준점
		int curVal; // 입력값과 기준점 사이의 거리를 구하기 위한 변수
		int answer=0; // 기준점과 가장 가까운 값을 담기위한 변수
		int minimum=0; // curVal중 최소값을 담기위한 변수, 그 최소값에 해당하는  answer값이 정답
		
		for(int i=0; i < numbers.length; i++) {
			
			// 입력값과 기준점 사이의 거리(절대값)
			curVal = a - numbers[i];
			if(curVal < 0) {
				curVal = -1*curVal;		
			}
			
			// 처음 돌때 변수 초기화
			if(i == 0) {
				minimum = curVal; 
				answer = numbers[i];
			}
			
			// 새로운 입력값과 기준점 사이의 거리(curVal)가  minimum보다 작으면 
			// minimum을 curVal로 바꾸고
			// answer도 새로운 입력값으로 바꿔준다.
			if(curVal < minimum) {
				minimum = curVal;
				answer = numbers[i];
			}
		}
		System.out.println("30에서 가장 가까운 숫자는 "+answer);
		
		////////// 기술통계 끝 ///////////
		
		// 정렬
		temp = 0;
		for(int i = 0; i < count; i++) {
			for(int j = i+1; j < count; j++) {				
				// 내림차순
				if(numbers[i] > numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}			
		}
		
		for(int i : numbers)
			System.out.print(i + "\t");
		System.out.println();
		
	}
}
