package com.example.demobook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
@Id
private int bookNo;
private String bookname;
private String bookauthor;
private String genre;
private String language;
private int publishyear;
private int price;
private int bookrating;
private int pageNo;
private int availability;
public int getBookNo() {
	return bookNo;
}
public void setBookNo(int bookNo) {
	this.bookNo = bookNo;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookauthor() {
	return bookauthor;
}
public void setBookauthor(String bookauthor) {
	this.bookauthor = bookauthor;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public int getPublishyear() {
	return publishyear;
}
public void setPublishyear(int publishyear) {
	this.publishyear = publishyear;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getBookrating() {
	return bookrating;
}
public void setBookrating(int bookrating) {
	this.bookrating = bookrating;
}
public int getPageNo() {
	return pageNo;
}

public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
}
public int getAvailability() {
	return availability;
}
public void setAvailability(int availability) {
	this.availability = availability;
}


}

