package com.example.demo.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class Users  implements Serializable {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String password;

	@Column(name = "user_name")
	private String userName;

	private Double balance;

	@Column(name = "idcard_num")
	private String idcardNum;

	@Column(name = "user_gender")
	private String userGender;

	@Column(name = "user_tel_num")
	private String userTelNum;

	@Column(name = "user_stdnum")
	private String userStdnum;

	@Column(name = "user_email")
	private String userEmail;

	private String authentication;

	@Column(name = "authentication_picture")
	private String authenticationPicture;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserTelNum() {
		return userTelNum;
	}

	public void setUserTelNum(String userTelNum) {
		this.userTelNum = userTelNum;
	}

	public String getUserStdnum() {
		return userStdnum;
	}

	public void setUserStdnum(String userStdnum) {
		this.userStdnum = userStdnum;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getAuthenticationPicture() {
		return authenticationPicture;
	}

	public void setAuthenticationPicture(String authenticationPicture) {
		this.authenticationPicture = authenticationPicture;
	}
}
