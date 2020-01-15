import java.io.File;
import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		File f = new File("c:\\Users\\admin\\Desktop\\cumulus-cloud.jpg");
		
		Integer i = new Integer(100);
		int j = i; // Auto Unboxing
		int k = 1000;
		i = k; // Auto Boxing
		
		Object obj = 300;
		System.out.println(((Integer)obj).intValue());
		// obj는 Integer를 저장하기는 했지만 변수의 자료형이 Object라서 강제형변환을 해줘야만 Integer의 
		// 메소드를 활용가능
		
		
		double a = 1.600000000000000;
		double b = 0.100000000000000;
		System.out.println(a+b);
		
		Double a1 = 1.600000000000000;
		Double b1 = 0.100000000000000;
		System.out.println(a1+b1);
		
		BigDecimal a2 = new BigDecimal(1.600000000000000); 
		BigDecimal b2 = new BigDecimal(0.100000000000000);
		System.out.println(a2.add(b2)); // BigDecimal로 정확한 값을 표현
		// 프로그래밍 언어와 데이터 베이스를 연동하는 경우
		// 대부분의 경우 데이터 베이스가 더 정밀한 숫자를 저장하는 경우가 많음
		// 데이터베이스에 실수를 저장했을 때는 float이나 Double로 받는것보다는 BigDecimal을 사용해야함
		// 같은 클래스를 이용해서 저장하고 연산한 후 결과를 float나 double로 표현하는 것이 좋음
	}
}
