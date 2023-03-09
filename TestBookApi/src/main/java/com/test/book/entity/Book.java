package com.test.book.entity;


public class Book {

	private int Id;
	private String bName;
	private String Auther;
	public Book(int id, String bName, String auther) {
		super();
		Id = id;
		this.bName = bName;
		Auther = auther;
	}
	
	public Book() {
		super();
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getAuther() {
		return Auther;
	}
	public void setAuther(String auther) {
		Auther = auther;
	}
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", bName=" + bName + ", Auther=" + Auther + "]";
	}
	
	
}
