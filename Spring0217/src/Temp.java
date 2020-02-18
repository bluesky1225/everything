
public class Temp {
	private int num;
	private String name;
	
	public Temp(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	public Temp() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "Temp [num=" + num + ", name=" + name + "]";
	}
}
