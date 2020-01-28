import java.util.function.Consumer;
import java.util.function.Function;

// 매개변수가 없고 리턴타입이 없는 메소드를 소유한 인터페이스
interface NoArgNoReturn {
	public void method1();
}

// 매개변수가 있고 리턴타입이 없는 메소드를 소유한 인터페이스 : 원본에 작업을 해서 원본을 변환시키거나 출력하는 인터페이스
interface OneArgNoReturn {
	public void method2(String msg);
}

// 매개변수는 없고 리턴타입만 있는 경우
interface NoArgOneReturn {
	public int method3();
}

// 매개변수가 있고 리턴타입도 있는 경우
interface OneArgOneReturn {
	public int method4(String number);
}

public class LambdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoArgNoReturn nanr = ()-> {
			System.out.println("NoArgNoReturn");
		};		
		nanr.method1();
		
		// 매개변수가 1개고 함수의 내용이 1줄이라서 (), {}를 생략가능
		OneArgNoReturn oanr = msg->System.out.println(msg);
		oanr.method2("OneArgNoReturn");
		
	
		NoArgOneReturn naor = ()->{
			return 1;
		};
		System.out.println(naor.method3());
		
		// 매개변수가 있고 리턴타입이 있는 경우 - 데이터를 가공해서 리턴하는 함수
		OneArgOneReturn oaor = number->{return Integer.parseInt(number);};
		System.out.println(oaor.method4("7"));
		
		
		Consumer<String> consumer = (a)->System.out.println(a);
		consumer.accept("java lambda");
		
		Function<String, String> function = (str)->{
			if(str.length()<= 3) return str;
			else return str.substring(0, 3)+"...";
		};
		String r = function.apply("hi");
		System.out.println(r);
		r = function.apply("Hello World");
		System.out.println(r);
		}
	}


