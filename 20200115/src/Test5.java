
public class Test5 {
	public static void main(String[] args) {
		
		String a = "gscvsgvssddsvsvsacvsgseggegacvsgtafsfs";
		//cvsg
		String result="";
		int temp=-4;
		for(int i = 0; i < a.length(); i++) {
			try {
				if((a.charAt(i)=='c'&&a.charAt(i+1)=='v'&&a.charAt(i+2)=='s'&&a.charAt(i+3)=='g') && i > temp + 3) {
					result = result + i +"번 ";
					temp = i;
				}
			} catch(Exception e) {
				System.out.println("그런 값은 없음");
			}
		}
		System.out.println(result+"인덱스가 정답");
	}
}
