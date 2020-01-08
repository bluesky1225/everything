
public class Fourth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(10.5%3.3);
		// 관계 연산
		
		int a = 1;
		int b = 2;
		int c = 3;
		System.out.println("1&2:"+(a&b));
		System.out.println("1|2:"+(a|b));
		System.out.println("1^2:"+(a^b));
		System.out.println("1^3:"+(a^c));
		System.out.println("3^2:"+(c^b));
		System.out.println("3^3:"+(c^c));
		System.out.println("~2:"+~b);
		System.out.println("-2:"+-b);
		
		int d = 10;
		boolean result = d<5 && (d++)>10;
		System.out.println("result : "+result);
		System.out.println("d : "+d);
		
		result = d < 1 || d > 1 && d < 100;
			
		
		System.out.println("result2 : "+result);
		
		boolean e = d % 4 == 0;
		System.out.println("10은 4이 배수인가? "+e);
		
		int year = 2020;
		
		e = year%4==0 && year%100>0 || year%400==0;
		System.out.println("2020년은 윤년인가? "+e);
		
		// 아래 second 변수의 값을 일, 시간, 분, 초로 나누어 출력하시오
		int second = 309209;
		
		int day = second/86400;
		second = second%86400;
		int hour = second/3600;
		second = second%3600;
		int minute = second/60;
		// 초를 구할때는 day부터 분까지 가져간 모든 것을 모두 빼면 되는데
		// 일, 시간, 분이 전부 60의 배수이기때문에
		// 60으로 나눈 나머지를 구하면 자연히 초만 남게 됨
		second = second%60;
		System.out.println(day + "일 "+hour + "시간 "+minute+"분 "+second+"초");
		
		
	}

}
