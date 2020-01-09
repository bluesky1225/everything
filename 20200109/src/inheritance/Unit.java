package inheritance;

abstract class Unit {
	int lev;
	int exp;
	int hp;
	int atk;
	int def;
	int max_exp;
	
	abstract void attack();
	abstract void defence();
}
