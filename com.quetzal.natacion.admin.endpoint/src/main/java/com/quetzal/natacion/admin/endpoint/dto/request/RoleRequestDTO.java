/**
 * Classname: RoleInsertRequestDTO.java
 * Author: Diego Hernandez Cote
 * Date: 11 feb 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto.request;

import java.io.Serializable;

/**
 * 
 */
public class RoleRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleInsertRequestDTO [name=" + name + ", description=" + description + "]";
	}
}
