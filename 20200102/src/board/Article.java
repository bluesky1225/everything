package board;



public class Article {

	private int num;
	private String title;
	private String content;
	
	private static int sequence;
	
	public Article() {
		sequence = sequence + 1;
		num = sequence;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", title=" + title + ", content=" + content + "]";
	}

	
}
