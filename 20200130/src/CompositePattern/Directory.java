package CompositePattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Directory implements Entry {
	private String name;
	List<Entry> list;
	public Directory(String name) {
		this.name = name;
		list = new ArrayList<Entry>();
	}
	
	@Override
	public void add(Entry entry) {
		// TODO Auto-generated method stub
		list.add(entry);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub		
		Iterator<Entry> iter = list.iterator();
		
		while(iter.hasNext()) {
			Entry entry = iter.next();
			
			if(entry.getClass().getName().equals("CompositePattern.Directory")) { // 클래스명이 디렉토리이면 확인을 받고 삭제한다.
				System.out.print("디렉토리입니다. 삭제하시겠습니까? Y OR N : ");
				Scanner sc = new Scanner(System.in);
				String answer = sc.nextLine();
				sc.close();
				if(answer.equals("Y")) entry.remove();
				else System.out.println("해당 디렉토리를 삭제하지 않습니다.");
			} else {
				
				entry.remove();
			}
		}
	}

	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	
}
