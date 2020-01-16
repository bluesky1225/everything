import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClassAndMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player = new Player(1, "이종범", 0.987);
		
		Map<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("num", 2);
		hm.put("name", "김길선");
		hm.put("hitRate", 0.391);
		
		// 모든 맵 공통 : 반복문 사용 가능
		Set<String> keys = hm.keySet();
		for(String key:keys)
			System.out.println(key+ " : " + hm.get(key));
		
		
		
	}

}
