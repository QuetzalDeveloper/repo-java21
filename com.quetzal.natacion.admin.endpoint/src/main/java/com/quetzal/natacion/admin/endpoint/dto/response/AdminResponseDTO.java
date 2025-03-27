/**
 * Classname: AdminResponseDTO.java
 * Author: Diego Hernandez Cote
 * Date: 14 feb 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto.response;

import java.io.Serializable;

public class AdminResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String account;
	private String name;
	private String lastName;
	private String phoneNumber;
	private Integer roleId;
	private String roleName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "AdminResponseDTO [id=" + id + ", email=" + email + ", account=" + account + ", name=" + name
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", roleId=" + roleId + ", roleName="
				+ roleName + "]";
	}
	
}
