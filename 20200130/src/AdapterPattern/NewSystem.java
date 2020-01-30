package AdapterPattern;

public class NewSystem extends OldSystem implements Target {
	public void process() {
		/* 전형적인 오버라이딩의 형태
		super.process();
		System.out.println("기능 추가");
		*/
		System.out.println("새로운 기능 추가");
	}
	
	public void legacyProcess() {
		super.process();
	}
}
