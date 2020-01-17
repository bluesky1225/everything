import java.util.UUID;

public class RandomUUID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = UUID.randomUUID().toString();
		
		// 랜덤한 문자열 만들기 - 이미지 파일등을 업로드 했을때 파일이름 그리고 유저를 구분하기위한 이름 등을 만들떄 이용
		System.out.println(name);
	}

}
