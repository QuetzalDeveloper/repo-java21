/**
 * Classname: UserRequest.java
 * Author: Diego Hernandez Cote
 * Date: 10 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.dto.request;

import java.io.Serializable;

/**
 * 
 */
public class UserRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String name;
	private String lastName;
	private String password;
	private String role;
	private String telephone;
	private String birthdate;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserRequest [username=" + username + ", name=" + name + ", lastName=" + lastName + ", password="
				+ password + ", role=" + role + ", telephone=" + telephone + ", birthdate=" + birthdate + ", email="
				+ email + "]";
	}
}
