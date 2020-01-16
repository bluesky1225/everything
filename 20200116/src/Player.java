
public class Player {
// 선수번호, 선수이름, 타율
	
	private int pNum; // 기본키
	private String pName;
	private double hitRate;
	
	public Player(int pNum, String pName, double hitRate) {
		super();
		this.pNum = pNum;
		this.pName = pName;
		this.hitRate = hitRate;
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getHitRate() {
		return hitRate;
	}

	public void setHitRate(double hitRate) {
		this.hitRate = hitRate;
	}

	@Override
	public String toString() {
		return "Player [pNum=" + pNum + ", pName=" + pName + ", hitRate=" + hitRate + "]";
	}
}
