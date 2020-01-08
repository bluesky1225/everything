
public class j20200107_2 {

	public static void main(String[] args) {
		System.out.println("스타트");
		// TODO Auto-generated method stub
		Sample s = new Sample();
		System.out.println("스타트2");
		//System.out.println(Sample.a);	에러
		System.out.println(s.a);		
		System.out.println(Sample.share);
		System.out.println(s.share);
		System.out.println(s.str);
		
		// static 변수는 하나만 만들어서 공유
		// 출력을 해보면 동일한 값을 출력
		Sample.share = 999;
		System.out.println(Sample.share);
		System.out.println(s.share);
		Sample s2 = new Sample();
		System.out.println(s2.share);
		
		//System.out.println(Sample.share2); // private static variable : not visible
		
		Sample.Sample_child s3 = s.new Sample_child();
		System.out.println(s3.sc);
		
		
	}

}
