import java.io.Serializable;

public class Unit implements Serializable {

	private int num;
	private String name;
	private int level;
	private int atk;
	private int def;
	
	// �Ű������� ���� ������ - �⺻�����Ͱ� �������� ���� �� ���
	public Unit() {
		super();
	}

	// ��� �Ӽ��� �Ű������� �޾Ƽ� �������ִ� ������
	// �⺻�����Ͱ� ���� �� �� ��� -  �׽�Ʈ �� �� ����
	public Unit(int num, String name, int level, int atk, int def) {
		super();
		this.num = num;
		this.name = name;
		this.level = level;
		this.atk = atk;
		this.def = def;
	}

	// ������ �޼ҵ�
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
