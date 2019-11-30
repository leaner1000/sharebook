package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "postedbook")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Postedbook  implements Serializable {
	@Id
	@Column(name = "rent_id")
	@GeneratedValue
	private Integer rent_id;

	@Column(name = "rent_book_id")
	private Integer rent_book_id;

	@Column(name = "rent_user_id")
	private String rent_user_id;

	private java.util.Date deadline;

	private Double price;

	private Double deposit;

	@Column(name = "rent_time")
	private Integer rent_time;

	private String status;

	private String cata;

	@Column(name = "book_name")
	private String book_name;

	@Column(name = "book_pub")
	private String book_pub;

	@Column(name = "book_author")
	private String book_author;

	private String isbn;

	private String picture;

	private String picture2;

	private String picture3;

	private String unused1;

	private String unused2;

	private String unused3;

	private String unused4;

	public Integer getRent_id() {
		return rent_id;
	}

	public void setRent_id(Integer rent_id) {
		this.rent_id = rent_id;
	}

	public Integer getRent_book_id() {
		return rent_book_id;
	}

	public void setRent_book_id(Integer rent_book_id) {
		this.rent_book_id = rent_book_id;
	}

	public String getRent_user_id() {
		return rent_user_id;
	}

	public void setRent_user_id(String rent_user_id) {
		this.rent_user_id = rent_user_id;
	}

	public Integer getRent_time() {
		return rent_time;
	}

	public void setRent_time(Integer rent_time) {
		this.rent_time = rent_time;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_pub() {
		return book_pub;
	}

	public void setBook_pub(String book_pub) {
		this.book_pub = book_pub;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCata() {
		return cata;
	}

	public void setCata(String cata) {
		this.cata = cata;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture1) {
		this.picture = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getUnused1() {
		return unused1;
	}

	public void setUnused1(String unused1) {
		this.unused1 = unused1;
	}

	public String getUnused2() {
		return unused2;
	}

	public void setUnused2(String unused2) {
		this.unused2 = unused2;
	}

	public String getUnused3() {
		return unused3;
	}

	public void setUnused3(String unused3) {
		this.unused3 = unused3;
	}

	public String getUnused4() {
		return unused4;
	}

	public void setUnused4(String unused4) {
		this.unused4 = unused4;
	}
}
