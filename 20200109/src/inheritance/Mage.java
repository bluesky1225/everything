package inheritance;

public class Mage extends Unit {
	int lev;
	int exp;
	int hp;
	int atk;
	int def;
	int max_exp;
	
	public Mage() { // 캐릭터 생성
		lev = 1;
		exp = 0;
		max_exp = lev * 100;
		hp = 10;
		atk = 5;
		def = 5;		
	}
	
	public Mage(int lev, int exp, int hp, int atk, int def) {
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
