
public class Generic<TEST> {
	// 미지정 자료형 TEST	
	private TEST[] data;
	private int a;
	
	//생성자
	public Generic(TEST [] data) {
		this.data = data;
	}
	
	public void disp() {
		for(TEST temp : data) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		int a = 10;
		System.out.println(a);
	}
	public String aaa(String a) {
		return a;
	}
	
	
	
}
