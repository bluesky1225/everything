package constructor;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Member member = new Member();
		
		System.out.println("아이디 : "+member.getId());
		System.out.println("패스워드 : "+member.getPw());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
		
		Member member2 = new Member(id, pw);
		
		System.out.println("아이디 : "+member2.getId());
		System.out.println("패스워드 : "+member2.getPw());
		
		sc.close();
		
		Member[] member3 = new Member[2];
		member3[0] = new Member();
		member3[1] = new Member(id, pw);
		
		System.out.println("아이디 : "+member3[0].getId());
		System.out.println("패스워드 : "+member3[0].getPw());
		
		System.out.println("아이디 : "+member3[1].getId());
		System.out.println("패스워드 : "+member3[1].getPw());
		
		
		Member origin = new Member();
		origin.setId("Origin");
		origin.setPw("4321");
		
		System.out.println("아이디 : "+origin.getId());
		System.out.println("패스워드 : "+origin.getPw());
		
		Member origin2 = origin.clone();
		
		Member weak = origin;
		weak.setId("Weak");
		weak.setPw("999");
		System.out.println("아이디 : "+origin.getId());
		System.out.println("패스워드 : "+origin.getPw());
		
		System.out.println("아이디 : "+origin2.getId());
		System.out.println("패스워드 : "+origin2.getPw());
	}
}
