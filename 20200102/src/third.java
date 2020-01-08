

public class third {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short a = (short)32768;
		System.out.print(a);
		byte b = (byte)-129;
		System.err.print(b);
		byte c = (byte)-129;
		
		System.err.println("안녕");
		System.out.println("a의 해쉬코드: "+ System.identityHashCode(a));
		System.out.println("b의 해쉬코드: "+ System.identityHashCode(b));
		System.out.println("c의 해쉬코드: "+ System.identityHashCode(c));
		
		System.out.printf("c의 해쉬코드는 %d다", System.identityHashCode(c));
		int d = 1;
		System.out.println(++d);
		//2
		System.out.println(d++);
		//2
		System.out.println(++d);
		//4
		System.out.println((d++));
		//4
		System.out.println(d++);
		//5
		System.out.println(d);
		//6
		
		int i = 1;
		/*
		for(;;) {
			try {
				int r = i%3;
				Thread.sleep(1000);// 1초마다
				if (r==1) {
					System.out.println("빨강");
				} else if(r == 2) {
					System.out.println("파랑");
				} else {
					System.out.println("노랑");
				}
				i+=1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		*/
		System.out.println(i>>31);
		System.out.println(i>>32);
		System.out.println(i>>33);
		System.out.println(i>>63);
		System.out.println(i>>64);
		System.out.println(i<<1);
	}

}
