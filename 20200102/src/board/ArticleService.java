package board;

// 게시판 작업을 위한 메소드
public class ArticleService {
	
	Article[] list = new Article[100];
	
	
	
	// 전체 목록이나 일부 목록을 리턴하는 메소드
	// 리턴타입은 배열이나 리스트
	// 검색 기능으로 글을 검색할땐 문자열을 받아서 제목, 내용과 비교하여 가져온다 
	public Article[] getList() { // 글 전체 가져오기
		return list;
	}
	
	public Article[] getList(int pageNum) { // 한 페이지의 글 가져오기
		Article[] list = new Article[10];
		// 한페이지에 10개씩 있다고 가정
		int start = 1+(pageNum-1)*1;
		int end = 10*pageNum;
		
		
		return null;
	}
	
	public Article[] getAriticle(int num) { // 게시물 내용 가져오기
		// list에서 num이라는 글 번호를 가진 데이터를 찾아서 리턴
		Article article = null;
		
		// list를 순회하면서 num과 같은 글번호를 가진 데이터를 article에 대입
		for(Article temp : list) {
			if(temp!=null) {
				// 동일한 글번호를 찾으면 더 이상 반복문을 실행할 이유가 없다
				if(temp.getNum() == num) {
					article = temp;
					break;
				}
			}
		}
		
		return null;
	}
	
	// 글 쓰기를 처리하는 메소드
	// 현재 작성된 글의 개수를 저장하기 위한 변수 - List를 사용하게되면 필요 없음
	private int cnt;
	public boolean insertAriticle(Article article) {
		// 맨 마지막 위치에 데이터를 대입
		list[cnt] = article;
		cnt++;
		return true;
	}
	
	// 글 수정을  처리하는 메소드
	public boolean updateAriticle(Article article) {
		// 수정후에는 setTitle(), setContent()
		for(int i = 0; i < cnt; i = i + 1) {
			Article imsi = list[i];
			// 글번호 비교
			if(imsi != null) {
				if(imsi.getNum() == article.getNum()) {
					list[i] = article;
					break;
				}
			}
		}
		
		return true;
	}
	
	// 글 삭제를 처리하는 메소드
	public boolean deleteAriticle(int num) {
		
		for(int i = 0; i < cnt; i++) {
			Article imsi = list[i];
			if(imsi != null) {
				if(imsi.getNum() == num) {
					list[i] = null;
					break;
				}
			}
		}
		return false;
	}
}
