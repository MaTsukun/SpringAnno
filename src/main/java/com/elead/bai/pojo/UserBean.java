package com.elead.bai.pojo;

import com.elead.bai.anno.Enumration;
import com.elead.bai.anno.Max;
import com.elead.bai.anno.Min;
import com.elead.bai.anno.NotBlank;

import javax.validation.constraints.NotNull;

public class UserBean {
	private Integer userid;

	@NotBlank
	private String username;

	@Enumration(options = { "男", "女" })
	private String sex;
	
	@Enumration(options = { "深圳", "广州" })
	private String city;

	private String address;

//	@NotNull
	@Min(options ="10")
	@Max(options ="30")
	private Integer age;

	public UserBean() {
	}

	public UserBean(Integer userid, String username, String sex, Integer age) {
		super();
		this.userid = userid;
		this.username = username;
		this.sex = sex;
		this.age = age;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
