package test;

public class MethodClass {
	int i=100;
	public void increase(int i) {
		i++;
		System.out.println(i);
		System.out.println(this.i);
	}
	
	public void increase(int[] i) {
		for(int j=0; j < i.length; j++) {
			i[j]++;
			System.out.println(i[j]);
		}
	}
	
	public void printAll(int... all) {
		for(int i:all) System.out.println(i);		
	}
	
	public int sum(int a, int b) {
		return (a+b);
	}
	
	//피보나치 수열
	public void fiv(int a, int b) {
		System.out.println(a);
		int c = a + b;
		if(c>100) {
			System.out.println(b);
			System.out.println(c);
			return ;
		} 
		fiv(b, c);
	}
	
	//피보나치수열(재귀x)
	public int fib(int n) {// n번째 피보나치 수열의 값을 구하여 리턴하는 메소드
		if(n == 1 || n == 2) {
			return 1;
		} else {
			// 피보나치 수열의 값을 저장할 변수
			int result = -1;
			
			// 계산할 값 이전 2번째 항의 값을 저장할 변수
			int f2 = 1;
			// 계산할 값 이전 1번째 항의 값을 저장할 변수
			int f1 = 1;
			
			if (f1 == 1 && f2 == 1) {// 피보나치 수열을 순서대로 찍어주기 위해 만듦
				System.out.print(f1+"\t"+f2+"\t");
			}
			
			// 1, 2번째 값 1을 설정해두었기에 3번째부터 값을 구하도록 함
			for(int i = 3; i <= n; i = i + 1) {
				result = f1 + f2;
				f1 = f2;
				f2 = result;
				System.out.print(result+"\t");// 피보나치 수열을 순서대로 찍어주기 위해 만듦
			}
			
			return result;
		}	
	}
	
	//피보나치수열 (재귀호출)
	public int fib2(int n) {
		if(n == 1 || n == 2) {
			return 1;
		} else {
			return fib2(n-1)+fib2(n-2); // 피보나치 수열의 인덱스를 가정
		}
	}
	
}