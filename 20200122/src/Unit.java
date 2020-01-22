import java.io.Serializable;

public class Unit implements Serializable {

	private int num;
	private String name;
	private int level;
	private int atk;
	private int def;
	
	// 매개변수가 없는 생성자 - 기본데이터가 제공되지 않을 때 사용
	public Unit() {
		super();
	}

	// 모든 속성을 매개변수로 받아서 생성해주는 생성자
	// 기본데이터가 제공 될 때 사용 -  테스트 할 때 좋음
	public Unit(int num, String name, int level, int atk, int def) {
		super();
		this.num = num;
		this.name = name;
		this.level = level;
		this.atk = atk;
		this.def = def;
	}

	// 접근자 메소드
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		atk += (level-1)*10;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	@Override
	public String toString() {
		return "Unit [num=" + num + ", name=" + name + ", level=" + level + ", atk=" + atk + ", def=" + def + "]";
	}
	
	
}
