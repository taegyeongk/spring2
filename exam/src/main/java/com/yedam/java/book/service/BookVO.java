package com.yedam.java.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private Integer bookno;
	private String bookname;
	private String bookcoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookdate;
	private Integer bookprice;
	private String bookpublisher;
	private String bookinfo;
	
	
	
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
	public String getBookcoverimg() {
		return bookcoverimg;
	}
	public void setBookcoverimg(String bookcoverimg) {
		this.bookcoverimg = bookcoverimg;
	}
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	public Integer getBookprice() {
		return bookprice;
	}
	public void setBookprice(Integer bookprice) {
		this.bookprice = bookprice;
	}
	public String getBookpublisher() {
		return bookpublisher;
	}
	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}
	public String getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(String bookinfo) {
		this.bookinfo = bookinfo;
	}
}