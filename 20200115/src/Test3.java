
public class Test3 {
	public static void main(String[] args) {
		String requestURI = "/member/login";
		
		// 위와같은 문자열이 있을때 마지막 / 다음에 문자열을 추출 - login
		// 위와같은 형태는 파일 경로에서 파일이름만 추출한다던가 웹 요청주소에서 공통되지 않은 부분 추출할때 많이 사용
		// split을 이용해서 해결, indexOf와 substring을 이용하기도 합니다.
		
		// 현재 운영체제가 windows 인지 확인
		String[] result = requestURI.split("/");
		System.out.println(result[result.length-1]);
		
		int i = requestURI.lastIndexOf("/");
		System.out.println(result[result.length-1].substring(0, result[result.length-1].length()));
		
		System.out.println(System.getProperty("os.name")+" "+System.getProperty("os.version"));
		// os에 window라는 문자열이 있는지 확인
		
		
		
		String temp = System.getProperty("os.name").toLowerCase();
		
		if(temp.lastIndexOf("windows") >= 0 && temp.lastIndexOf("windows") < temp.length()-1) {
			System.out.println("인덱스는 "+temp.lastIndexOf("windows")+"입니다. 윈도우입니다");
		}
		
		int idx = System.getProperty("os.name").toLowerCase().indexOf("windows");
		
		if(idx < 0) {
			System.out.println("윈도우가 아닙니다");
		} else {
			System.out.println("윈도우입니다");
		}
		
		
	}
}
