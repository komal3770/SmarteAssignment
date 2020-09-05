package com.smarte.assignment.beans;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.smarte.assignment.util.StatusEnum;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String userName;
	private String password;
	private Integer age;
	private Double ctc;
	private Date joiningDate;
	private StatusEnum status;
	
	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;
	
	@Embedded
	private Address address;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", ctc=" + ctc + ", joiningDate=" + joiningDate + ", status=" + status + ", department=" + department
				+ ", address=" + address + "]";
	}
	
	
}
