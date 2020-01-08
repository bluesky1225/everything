import java.util.Scanner;

public class j20200106 {
	
	public static void 교번처리() {
		for(int i = 0; i < 10; i++) {
			if(i%2==0)
				System.out.println("ON");
			else
				System.out.println("OFF");
		}
	}
	
	public static void 동아일보_자바기사_크롤링() { //준비중
		String url = null;
		final int articleCount = 1164;
		final int pageCount = articleCount%15==0 ? articleCount/15 : articleCount/15+1;
		int p = 0;
		
		/* pageCount = articleCount / 15;
		 * 
		 * if(articleCount % 15 != 0) {
		 * 	pageCount = pageCount + 1;
		 * }
		 */		
		
		for(int i = 0; i < pageCount; i = i + 1) {
			p = 15 * i + 1;
			url= "http://www.donga.com/news/search?p="+p+"&query=%EC%9E%90%EB%B0%94&check_news=1&more=1&sorting=1&search_date=1&v1=&v2=&range=1";
			
			System.out.println("url : "+url);		
		}
	}
	
	public static void 정수를_입력받아서_소수_판별하기() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("소수인지 아닌지 판별할 정수를 입력하세요 : "); 
		int su = sc.nextInt();
		boolean flag = false;
		
		for(int i = 2; i <= su/2; i++) {
			if(su % i == 0) {
				flag = true;
				break;
			}
		}
		
		if(flag == false)
			System.out.println(su+"는 소수입니다.");
		else
			System.out.println(su+"는 소수가 아닙니다.");
		
		sc.close();
	}
	
	public static void 소수_개수_구하기_2부터_1000까지() {
		
		boolean flag;
		int count = 0;
		
		for(int i = 2; i <= 1000; i++) {
			flag = false;
			
			for(int j = 2; j <= i/2; j++) {
				
				if(i % j == 0) {
					flag = true;
					break;
				}
				
			}
			if ((i == 2 || i == 3) || flag == false)
				count = count + 1;
		}
		
		System.out.println("2부터 1000까지 숫자중 소수는 "+count+"개입니다.");
		
	}
	
	
	/*
	public static void 별찍기() {
		
		for(int i = 0; i < ) {
			if(i<=2) {
				for(int j = 0; j) {
					if(i<=2) {
						
					}
				}
			} else {
				for(int j = 0; j) {
					if(i<=2) {
						
					}
				}
			}
			
		}
		*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outer : for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 11; j = j + 1) {
				if(j%4==0) continue;
				System.out.println("j : "+j);
				
				if(j%9==0)
					//break; 		// 이렇게 하면 for (int j = 1; j < 11; j = j + 1) {}를 빠져나가고
					break outer;	// 이렇게 하면 outer 레이블을 빠져나간다
			}
		}
	
		교번처리();
		동아일보_자바기사_크롤링();
		정수를_입력받아서_소수_판별하기();
		소수_개수_구하기_2부터_1000까지();
		//별찍기();
	}	
	
}
