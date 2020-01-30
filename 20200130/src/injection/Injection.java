package injection;

public class Injection {
	private String common;	// 모든 인스터스들이 "Java"라고 저장해서 사용
	private String diff1;	// 인스턴스들마다 다름
	private String diff2;	// 인스턴스들마다 다름
		
	public Injection(String diff1) {
		common = "java";
		this.diff1 = diff1;
	}
	
	public void setDiff2(String diff2) {
		this.diff2 = diff2;
	}
	
	public void disp() {
		System.out.println(common.toUpperCase());
		System.out.println(diff1.toUpperCase());
		System.out.println(diff2.toUpperCase());
	}

	
}
