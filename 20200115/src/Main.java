import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test9 t = new Test9();
		t.setName("김");
		t.setNum(7);
		t.setScore(90);
		
		Test9 t2 = new Test9();
		t2.setName("박");
		t2.setNum(2);
		t2.setScore(10);
		
		Test9 t3 = new Test9();
		t2.setName("이");
		t2.setNum(5);
		t2.setScore(100);
		Test9[] tList = {t, t2, t3};
		
		Arrays.sort(tList);
		
		for(Test9 i:tList)
			System.out.print(i+" ");
		/*
		 * Comparable 인터페이스 미구현시
		 	Exception in thread "main" java.lang.ClassCastException: Test9 cannot be cast to java.lang.Comparable
			at java.util.ComparableTimSort.countRunAndMakeAscending(Unknown Source)
			at java.util.ComparableTimSort.sort(Unknown Source)
			at java.util.Arrays.sort(Unknown Source)
			at Main.main(Main.java:23)
		 */
		
		// 기본형
		Comparator <Test9> tc = new Comparator <Test9>() {
			public int compare(Test9 arg0, Test9 arg1) {
				if(arg0.getScore() > arg1.getScore()) {
					return 1;
				}else if(arg0.getScore() == arg1.getScore()) {
					return 0;
				} else {
					return -1;
				}
			}
		};
		
		System.out.println();
		System.out.print("정렬조건 1 번호 2 이름 3 점수 : ");
		Scanner sc = new Scanner(System.in);
		
		switch(sc.nextInt()) {
		case 1:
			tc = new Comparator<Test9>() {
				public int compare(Test9 t1, Test9 t2) {
					if(t1.getNum() > t2.getNum()) {
						return 1;
					} else if(t1.getNum() == t2.getNum()) {
						return 0;
					} else {
						return -1;
					}
				}
			};
			break;
		case 2:
			tc = new Comparator<Test9>() {
				public int compare(Test9 t1, Test9 t2) {
					return t1.getName().compareTo(t2.getName());
				}
			};
			break;
		case 3:
			tc = new Comparator<Test9>() {
				public int compare(Test9 t1, Test9 t2) {
					return t1.getScore() > t2.getScore() ? 1 : t1.getScore() == t2.getScore() ? 0 : -1;
				}
				
			};
			break;
		default: 
			tc = new Comparator<Test9>() {
				public int compare(Test9 t1, Test9 t2) {
					//return t1.getScore() - t2.getScore();
					return t2.getScore() - t1.getScore();
				}				
			};
			break;
		}
		
		Arrays.sort(tList, tc);
		
		for(Test9 j : tList)
			System.out.print(j + " ");
		
		sc.close();
		
	}

}
