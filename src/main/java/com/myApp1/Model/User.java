package com.myApp1.Model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author SAHUL this is a User class which is mapped to User table in course
 *         registration schema
 *
 */
@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Email(message = "should be an valid email address")
	@NotBlank(message = "user name shouldnt be blank")
	private String userName;

	@NotBlank(message = "password is required")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})", message = "Password should have atleast 1 digit, 1 lowercase, 1 uppercase and with a min length of 6 and max length of 10")
	private String passWord;

	private LocalTime createTime;
	private LocalTime updateTime;

	@NotBlank(message = "firstname Shouldnot be blank")
	private String firstName;

	@NotBlank(message = "lastname shouldnot be blank")
	private String lastName;

	private String middleName;

	private String company;
	private Long phoneNumber;

	public User(String userName, String passWord, LocalTime createTime, LocalTime updateTime, String firstName,
			String lastName, String middleName, String company, Long phoneNumber) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.company = company;
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public LocalTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}

	public LocalTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + "]";
	}

}
