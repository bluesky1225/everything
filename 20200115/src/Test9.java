
public class Test9 implements Comparable<Test9> {
	private int num;
	private String name="ggss";
	private int score;
	
	@Override
	public String toString() {
		return "Test9 [num=" + num + ", name=" + name + ", score=" + score + "]";
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public int compareTo(Test9 t) {
		int result=0;
		/*
		if(this.num > t.num) {
			result = 1;
		} else if(this.num == t.num) {
			result = 0;
		} else  {
			result = -1;
		}
		
		return result;
		*/ 
		return this.name.compareTo(t.name)*-1;
	}
	
	
}
