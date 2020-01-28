
public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 생성
		Thread t1 = new Thread(new RunnableImple());
		
		// 익명 클래스 생성
		// 클래스명(인스턴스 변수명)이 생략
		Thread t2 = new Thread(new RunnableImple() {
			public void run() {
				try {
					for(int i=0; i<10; i++) {
						Thread.sleep(300);
						System.out.println("익명 클래스를 만들어서 사용");
					}
				}catch(Exception e) {
					System.out.println("예외 발생 : "+e.getMessage());
				}				
			}
		});
		
		// 람다로 익명 클래스 생성
		// 인스턴스를 만드는 과정도 없고 메소드 이름도 없지만 위와 동일한 기능을 수행
		// 코드가 간결해지고 컬렉션 요소에 필터링 또는 매핑에 도입해서 집계를 사용할 수 있도록 해줌
		Thread t3 = new Thread(
			()->{
				try {
					for(int i=0; i<10; i++) {
						Thread.sleep(500);
						System.out.println("람다를 만들어서 사용");
					}
				}catch(Exception e) {
					System.out.println("예외 발생 : "+e.getMessage());
				}
			}
		);
		
		Runnable r = ()->{
			try {
				for(int i=0; i<10; i++) {
					Thread.sleep(100);
					System.out.println("람다를 만들어서 사용2");
				}
			}catch(Exception e) {
				System.out.println("예외 발생 : "+e.getMessage());
			}
		};
		
		Thread t4 = new Thread(r);
		
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				try {
					for(int i=0; i<10; i++) {
						Thread.sleep(100);
						System.out.println("익명 클래스를 만들어서 사용2");
					}
				}catch(Exception e) {
					System.out.println("예외 발생 : "+e.getMessage());
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
