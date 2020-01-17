import java.util.*;

public class RandomMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] image = {"!", "@", "#", "$", "%", "^"};
		
		Random r=new Random();
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i<3; i++) {
			String temp = image[r.nextInt(image.length)];
			System.out.print(temp);
			list.add(temp);
		}
		System.out.print("\n");
		
		if(list.get(0) == list.get(1) && list.get(1) == list.get(2)) {
			System.out.println("3개가 모두 일치");
		} else if(list.get(0) == list.get(1)) {
			System.out.println("앞 2개가 일치");
		} else {
			System.out.println("꽝");
		}
	}

}
