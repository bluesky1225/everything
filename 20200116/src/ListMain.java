import java.util.*;
public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player(1, "이대호", 0.355);
		
		Player player2 = new Player();
		player2.setpNum(2);
		player2.setpName("이승엽");
		player2.setHitRate(4.121);
		
		Player player3 = new Player(3, "김우영", 0.431);		

		Player player4 = new Player(4, "최지만", 0.362);
		
		Player player5 = new Player(5, "장길영", 0.385);
		
		
		ArrayList<Player> ar = new ArrayList<Player>();
		
		ar.add(player1);
		ar.add(player2);
		ar.add(player3);
		ar.add(player4);
		ar.add(player5);
		
		ar.sort(new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				// TODO Auto-generated method stub
				if(p1.getHitRate()>p2.getHitRate()) {
					return 1;
				} else if (p1.getHitRate()==p2.getHitRate()) {
					return 0;
				} else {
					return -1;
				}
			}
			
		});
		
		// 데이터 출력
		for(Player player:ar)
			System.out.print(player.toString()+" ");
		
		System.out.println();
		
		ar.sort(new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				// TODO Auto-generated method stub
				return p1.getpName().compareTo(p2.getpName())*-1;
			}
			
		});
		
		// 데이터 출력
		for(Player player:ar)
			System.out.print(player.toString()+" ");
	}

}
