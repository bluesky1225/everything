import java.util.*;
public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("baseball", "야구");
		hm.put("soccer", "축구");
		hm.put("volleyball", "배구");
		
		System.out.println(hm.get("baseball"));
		
		String soccer = (String)hm.get("soccer");
		
		System.out.println(soccer);
		hm.put("volleyball", "발리볼");
		System.out.println(hm.get("volleyball"));
		
		System.out.println(hm.get("basketball"));
		
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		
		System.out.println();
		
		for(String key:hm.keySet())
			System.out.println(key+":"+hm.get(key));
	}

}
