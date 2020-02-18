package sqlmapper;

import lombok.Data;

@Data
public class Goods {
	private int code;
	private String name;
	private String manufacturer;
	private int price;
}
