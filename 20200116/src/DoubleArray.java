import java.util.ArrayList;
import java.util.*;

public class DoubleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> kCar = new ArrayList<String>();
		kCar.add("아반테");
		kCar.add("소나타");
		kCar.add("그랜저");
		
		ArrayList<String> fCar = new ArrayList<String>();
		fCar.add("Forche");
		fCar.add("BMW");
		fCar.add("Benz");
		
		
		
		ArrayList<ArrayList<String>> car = new ArrayList<ArrayList<String>>();
		car.add(kCar);
		car.add(fCar);
		
		
		for(int i=0; i<car.size(); i++) {
			if(i==0)
				System.out.print("국산 : ");
			else
				System.out.print("외산 : ");
			
			ArrayList<String> al = car.get(i);
			
			
			for(String carName:al) {
				System.out.print(carName+"\t");
			}
			System.out.println();
		}
		

		/*
		for(ArrayList<String> al:car) {
			
			for(String carName:al) {
				System.out.println(carName);
			}
		}
		*/
		
		
		System.out.println("=================================");
		
		
		
		Map<String, Object> map1 = new HashMap<String, Object>();

		map1.put("분류", "국산차");
		map1.put("차종", kCar);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
	
		map2.put("분류", "외제차");
		map2.put("차종", fCar);
		
		
		ArrayList<String> sCar = new ArrayList<String>();
		sCar.add("트랙터");
		sCar.add("레미콘");
		sCar.add("불도저");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		
		map3.put("분류", "기타");
		map3.put("차종", sCar);
		
		ArrayList<Map<String, Object>> ar = new ArrayList<Map<String, Object>>();
		ar.add(map1);
		ar.add(map2);
		ar.add(map3);
		
		for(Map<String, Object> map:ar) {
			System.out.print(map.get("분류")+": ");
			ArrayList<String> arTemp = (ArrayList<String>)map.get("차종"); 
			
			for(String carName:arTemp) {
				System.out.print(carName+"\t");
			}
			System.out.print("\n");
		}
		
	}

}
