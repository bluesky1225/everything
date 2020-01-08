package test;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleClass sc = new SampleClass();
		sc.sample();
		//SampleClass sc2 = new SampleClass();
		
		System.out.println(sc.a);
		sc.a = 777;
		System.out.println(sc.a);
		
		SampleClass.a = 10000;
		System.out.println(SampleClass.a);
		
		MethodClass mc = new MethodClass();
		
		int a = 1;
		int[] b = {10, 20, 30};
		mc.increase(a);
		System.out.println(a);
		mc.increase(b);
		for(int i:b) {			
			System.out.println(i);
		}
		
		mc.printAll(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		
		// 리턴값을 활용하여 다음 작업을 수행
		int sum = mc.sum(10,20);
		int avg = sum/2;
		System.out.println(avg);
		
		mc.fiv(1, 1);
	}

}
