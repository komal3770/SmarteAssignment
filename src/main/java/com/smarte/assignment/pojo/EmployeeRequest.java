package com.smarte.assignment.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmployeeRequest {
	private Long empId;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private Integer age;
	@NotNull
	private Double ctc;
	@NotNull
	private Long deptId;
	@NotNull
	private Date joiningDate;
	private Boolean status;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String country;
	@NotNull
	private String pincode;
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getCtc() {
		return ctc;
	}
	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "EmployeeRequest [empId=" + empId + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", ctc=" + ctc + ", deptId=" + deptId + ", joiningDate=" + joiningDate + ", status=" + status
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
}
