/**
 * Classname: AdminDTO.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer roleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRole() {
		return roleId;
	}
	public void setRole(Integer role) {
		this.roleId = role;
	}
	
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", name=" + name + ", role=" + roleId + "]";
	}

}
