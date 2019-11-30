package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rent_record")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class RentRecord  implements Serializable {
	@Id
	@Column(name = "rent_recorder_id")
	@GeneratedValue
	private Integer rent_recorder_id;

	@Column(name = "rent_id")
	private Integer rent_id;

	@Column(name = "renter_id")
	private String renter_id;

	private String status;

	@Column(name = "rent_time")
	private java.util.Date rent_time;

	@Column(name = "expire_time")
	private java.util.Date expire_time;

	private String cata;
    //书名
	private String unused1;
	//图片
	private String unused2;
	//价格
	private String unused3;
	//租期
	private String unused4;

	public Integer getRent_recorder_id() {
		return rent_recorder_id;
	}

	public void setRent_recorder_id(Integer rent_recorder_id) {
		this.rent_recorder_id = rent_recorder_id;
	}

	public Integer getRent_id() {
		return rent_id;
	}

	public void setRent_id(Integer rent_id) {
		this.rent_id = rent_id;
	}

	public String getRenter_id() {
		return renter_id;
	}

	public void setRenter_id(String renter_id) {
		this.renter_id = renter_id;
	}

	public Date getRent_time() {
		return rent_time;
	}

	public void setRent_time(Date rent_time) {
		this.rent_time = rent_time;
	}

	public Date getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Date expire_time) {
		this.expire_time = expire_time;
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
