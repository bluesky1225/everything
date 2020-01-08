package test;

class SampleClass {
	
	static int a;
	
	int b = 1;

	static {
		System.out.println("static 영역 1");
		a = 999;
	}
	static {
		System.out.println("static 영역 2");
	}
	protected void sample() {
		System.out.println("디폴트");	
		cal();
	}
	
	private void cal() {
		System.out.println(10);
	}
	
	
}
