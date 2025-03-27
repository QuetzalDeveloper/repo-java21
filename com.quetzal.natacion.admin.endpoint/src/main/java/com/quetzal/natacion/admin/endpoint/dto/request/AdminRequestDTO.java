/**
 * Classname: AdminRequestDTO.java
 * Author: Diego Hernandez Cote
 * Date: 14 feb 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdminRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
			
	private String email;
	private String account;
	private String password;
	private String name;
	private String lastName;
	private LocalDateTime birthday;
	private String phoneNumber;
	private Integer role_id;
	private String curp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	@Override
	public String toString() {
		return "AdminRequestDTO [email=" + email + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", lastName=" + lastName + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", role_id="
				+ role_id + ", curp=" + curp + "]";
	}
}
