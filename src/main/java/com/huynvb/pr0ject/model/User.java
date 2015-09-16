package com.huynvb.pr0ject.model;
//Generated Sep 1, 2015 10:10:43 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* User generated by hbm2java
*/
@Entity
@Table(name = "tbl_user", catalog = "uchinews")
public class User implements java.io.Serializable {

	private String username;
	private String password;
	private String familyName;
	private int sex;
	private int enabled;
	private boolean hiddenFlg;
	private String birthday;
	private String mobile;
	private String email;
	private String address;
	private Integer roleId;

	public User() {
	}

	public User(String username, String password, String familyName,
			int sex, int enabled, boolean hiddenFlg) {
		this.username = username;
		this.password = password;
		this.familyName = familyName;
		this.sex = sex;
		this.enabled = enabled;
		this.hiddenFlg = hiddenFlg;
	}

	public User(String username, String password, String familyName,
			int sex, int enabled, boolean hiddenFlg,
			String birthday, String mobile, String email, String address,
			Integer roleId) {
		this.username = username;
		this.password = password;
		this.familyName = familyName;
		this.sex = sex;
		this.enabled = enabled;
		this.hiddenFlg = hiddenFlg;
		this.birthday = birthday;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.roleId = roleId;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "family_name", nullable = false, length = 50)
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name = "sex", nullable = false)
	public int getSex() {
		return this.sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Column(name = "enabled", nullable = false)
	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Column(name = "hidden_flg", nullable = false)
	public boolean isHiddenFlg() {
		return this.hiddenFlg;
	}

	public void setHiddenFlg(boolean hiddenFlg) {
		this.hiddenFlg = hiddenFlg;
	}

	@Column(name = "birthday", length = 10)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "mobile", length = 16)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "role_id")
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}