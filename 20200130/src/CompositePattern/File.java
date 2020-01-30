package CompositePattern;

public class File implements Entry {
	private String name;
	
	public File(String name) {
		this.name = name;
	}
	@Override
	public void add(Entry entry) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		System.out.println(name+"이 삭제되었습니다.");
	}

	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		 this.name = name;
	}

	
}
