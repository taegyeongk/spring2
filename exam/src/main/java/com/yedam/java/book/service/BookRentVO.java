package com.yedam.java.book.service;

import java.util.Date;

public class BookRentVO {
	private Integer bookno;
	private String bookname;
	public Integer getBookno() {
		return bookno;
	}
	public void setBookno(Integer bookno) {
		this.bookno = bookno;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	private String rent_no;
	private String rent_price;
	private Date rent_date;
	private String rent_status;
	private Integer sum;
	private Integer count;
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getRent_no() {
		return rent_no;
	}
	public void setRent_no(String rent_no) {
		this.rent_no = rent_no;
	}
	public String getRent_price() {
		return rent_price;
	}
	public void setRent_price(String rent_price) {
		this.rent_price = rent_price;
	}
	public Date getRent_date() {
		return rent_date;
	}
	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}
	public String getRent_status() {
		return rent_status;
	}
	public void setRent_status(String rent_status) {
		this.rent_status = rent_status;
	}
	
	
	
	
	
}