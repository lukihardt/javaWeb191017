package sopo.cn.model20191023;

import java.sql.Date;

public class Book {
	private int id;
	private String b_name;
	private double b_price;
	private int author_id;
	private Date publish_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public double getB_price() {
		return b_price;
	}
	public void setB_price(double b_price) {
		this.b_price = b_price;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", b_name=" + b_name + ", b_price=" + b_price + ", author_id=" + author_id
				+ ", publish_date=" + publish_date + "]";
	}
	
	
}
