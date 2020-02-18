import java.sql.Date;

public class Dto {
	private int tCode;
	private String pCode;
	private String pName;
	private int price;
	private int amount;
	private Date tDate;
	private String tId;
	
	public Dto(int tCode, String pCode, String pName, int price, int amount, Date tDate, String tId) {
		this.tCode=tCode;
		this.pCode=pCode;
		this.pName=pName;
		this.price=price;
		this.amount=amount;
		this.tDate=tDate;
		this.tId=tId;
	}

	public int gettCode() {
		return tCode;
	}

	public void settCode(int tCode) {
		this.tCode = tCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}
	
	
}
