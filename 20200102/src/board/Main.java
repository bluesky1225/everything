package board;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int 전체보기 = 1;
		final int 상세보기 = 2;
		final int 삽입하기 = 3;
		final int 수정하기 = 4;
		final int 삭제하기 = 5;
		final int 종료 = 6;
		
		Scanner sc = new Scanner(System.in);
		String title = null;
		String content = null;
		boolean flag = false;
		ArticleService articleService = new ArticleService();
		
		while(true) {
			System.out.println("1.전체보기  2.상세보기  3.삽입하기  4.수정하기  5.삭제하기  6.종료");
			System.out.print("메뉴 입력 : ");
			
			
			int menu = sc.nextInt();
			
			switch(menu) {
			case 전체보기:
				System.out.println("전체보기 선택");
				
				Article[] articles = articleService.getList();
				for(Article article : articles) {
					if(article!=null) {
						System.out.println(article);
					}
				}
				break;
			case 상세보기:
				System.out.println("상세보기 선택");
				System.out.print("글번호를 입력하세요 : ");
				int num = sc.nextInt();
				Article article3 = articleService.getArticle(num);
				if(article3 == null) {
					System.out.println("해당하는 글 번호가 없습니다.");
					
				} else {
					System.out.print("번호 : ");
					System.out.println(article3.getNum());
					System.out.print("제목 : ");
					System.out.println(article3.getTitle());
					System.out.print("내용 : ");
					System.out.println(article3.getContent());
				}
				
				
				
				break;
			case 삽입하기:
				System.out.println("삽입하기 선택");
				Article article = new Article();
				sc.nextLine(); // 메뉴숫자 입력후 남은  enter 제거용
				System.out.print("제목 : ");
				title = sc.nextLine();
				article.setTitle(title);
				System.out.print("내용 : ");
				content = sc.nextLine();
				article.setContent(content);
				
				if(title != null && content != null) 
					flag = articleService.insertAriticle(article);					
				
				if(flag = true) {
					System.out.println(article);
					System.out.println("삽입이 완료되었습니다.");
				}
				break;
			case 수정하기:
				System.out.println("수정하기 선택");
				System.out.print("수정할 글번호를 입력하세요 : ");
				int num2 = sc.nextInt();
				
				Article article2 = articleService.getArticle(num2);
				
				if(article2 == null) {
					System.out.println("번호에 해당하는 글이 없습니다");
					continue;
				}
				System.out.println(num2+"번 글을 수정합니다. 수정할 내용을 입력하세요");
				System.out.print("제목 : ");
				title = sc.nextLine();
				System.out.print("내용 : ");
				content = sc.nextLine();
				article2.setTitle(title);
				article2.setContent(content);
				
				flag = articleService.updateAriticle(article2);
				
				if(flag == true) {
					System.out.println(article2);
					System.out.println("수정에 성공하였습니다.");
				}
				
				break;
			case 삭제하기:
				System.out.println("삭제하기 선택");
				System.out.print("삭제할 글 번호를 입력하세요 : ");
				int num3 = sc.nextInt();
				
				//글의 존재유무 확인
				Article article4 = articleService.getArticle(num3);
				if(article4 == null) {
					System.out.println("글번호가 존재하지 않습니다.");
					break;					
				}
				System.out.print("정말 삭제하시겠습니까?(Y/N) ");
				sc.nextLine();
				String answer = sc.nextLine();
				
				if(answer.equals("N") || answer.equals("n")) {
					System.out.println("삭제를 취소하고 메뉴로 돌아갑니다.");
					continue;
				} else if(answer.equals("Y") || answer.equals("y")) {
					flag = articleService.deleteAriticle(num3);
				} else {
					System.out.println("잘못 입력하셨습니다. 메뉴로 돌아갑니다.");
					continue;
				}
				
				if(flag == true) {
					System.out.println("삭제에 성공하였습니다.");
				} else {
					System.out.println("삭제에 실패하였습니다.");
				}
				break;
			case 종료:
				System.out.println("프로그램 종료");
				sc.close();
				System.exit(0); // 프로그램 종료
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		
		
		}
		//sc.close();
	}

}
