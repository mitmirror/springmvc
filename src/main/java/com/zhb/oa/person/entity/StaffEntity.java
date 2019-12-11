package com.zhb.oa.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="staff")
public class StaffEntity {
	/*
	 * 员工ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="staffId")
	private Integer staffId;
	/*
	 * 密码
	 */
	@Column(name="password")
	private String password;
	
	/*
	 * 员工姓名
	 */
	@Column(name="staffName")
	private String staffName;
	
	/*
	 * 员工性别
	 */
	@Column(name="staffSex")
	private String staffSex;
	
	/*
	 * 员工年龄
	 */
	@Column(name="staffAge")
	private Integer staffAge;
	
	/*
	 * 员工职位
	 */
	@Column(name="position")
	private String position;
	
	/*
	 * 员工住址
	 */
	@Column(name="staffAddress")
	private String staffAddress;
	
	/*
	 * 员工电话
	 */
	@Column(name="staffPhone")
	private String staffPhone;
	

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public Integer getStaffAge() {
		return staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return "staffId:"+staffId+"\npassword:"+password+"\nname:"+staffName;
		
	}

}
