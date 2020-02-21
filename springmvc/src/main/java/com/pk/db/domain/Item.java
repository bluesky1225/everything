package com.pk.db.domain;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= {"itemid", "itemname", "price", "description", "pictureurl"})
public class Item {
	private int itemid;
	private String itemname;
	private int price;
	private String description;
	private String pictureurl;
}
