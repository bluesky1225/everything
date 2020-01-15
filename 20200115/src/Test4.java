import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "eros";
		Scanner sc = new Scanner(System.in);
		
		
		String input = sc.nextLine();
		
		char[] temp2 = new char[temp.length()];
		
		for(int i = 0; i < temp.length(); i++) {
			temp2[i] = temp.charAt(i);
		}
		int count = 0;
		for(char a:temp2) {
			for(int i = 0; i<input.length(); i++) {
				if(input.charAt(i) == a) {
					count++;
				}
			}
		}
		if (count == temp.length())
			System.out.println("anagram입니다");
		
		sc.close();
		
	}

}
