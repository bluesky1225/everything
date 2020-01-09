package inheritance;

public class Knight extends Unit {
	int lev;
	int exp;
	int hp;
	int atk;
	int def;
	int max_exp;
	
	public Knight() { // 캐릭터 생성
		lev = 1;
		exp = 0;
		max_exp = lev * 100;
		hp = 10;
		atk = 5;
		def = 5;		
	}
	
	public Knight(int lev, int exp, int hp, int atk, int def) { // 재접속
		this.lev = lev;
		this.exp = exp;
		this.max_exp = lev * 100;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	public void attack() {
		
	}
	
	void defence() {
		
	}
}
