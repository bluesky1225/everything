
public class Second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isNum = true;
		// 변수의 값을 출력
		System.out.println("isNum : "+isNum);
		
		int age = 50;
		System.out.println("강사님 나이 : "+age);
		
		char ch = 'a'+1;
		int c = 'a';
		short c2 = 'b';
		System.out.println(ch);
		System.out.println(c);
		System.out.println(c2);
		
		int i = 1;
		int sum = 0;
		for(int j=0; j<1000; j=j+1) {
			sum +=i;
		}
		System.out.println(sum);
		
		double i2 = 0.1;
		double sum2 = 0;
		for(int j=0; j<1000; j=j+1) {
			sum2 +=i2;
		}
		System.out.println(sum2);
		
		System.out.println(1-0.8);
		
		double height = 188.8;
		double weight = 77.7;
		
		int size = 10;
		
		System.out.println("키와 몸무게의 합 : "+(height*size+weight*size)/size);
		
		char a = 65;
		char b = 97;
		// char c = a + b; 에러
		
		byte d = 1;
		byte e = 1;
		// byte f = d + e; 에러
		
		short g = 1;
		short h = 1;
		// short i = g + h; 에러
		
		// long을 float으로 형변환
		float j = 100000L;
		System.out.println("float 100000은 "+j);
		
		byte k = 1; // (int형) 1은 형변환되어 대입되도록 처리함
		// byte l = 1L; 오류. long을 byte에 대입 불가. 자동형변환 불가.
		byte m = (byte)1L; // 강제형변환으로 대입할 수 있다
		
		System.out.println(m);
		
		System.out.println(5.1 * 10L); // double과 long형 연산시 결과도 double
		
		System.out.println(10/(double)3);
		System.out.println(10*1.0/3);
		System.out.println(10.0/3);
		
		System.out.println(10/3*1.0);
		
		System.out.println((int)(10.3/5.2));
		System.err.println((long)(7.4/2.1f));
		
		double r = (double)10 / 4;
		System.out.println(r);
		
		double x = 18.7;
		int y = (int)x;
		double z = x%y;
		int result;
		if (z > 0.4) {
			result = y+1;
		} else {
			result = y;
		}
		System.err.println("반올림 결과 : "+result);
		
		result = (int)(x + 0.5); // 이렇게 할 수 있다
		
		result = (int)(x*0.1+0.5)*10; // 1의 자리를 반올림
		
	}

}
