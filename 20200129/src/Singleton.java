
public class Singleton {
	private static Singleton obj;
	private String name;
	public static Singleton sharedInstance() {
		if(obj == null) obj = new Singleton();
		return obj;
	}
	
	private Singleton() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
