/**
 * Classname: RoleUpdateRequestDTO.java
 * Author: Diego Hernandez Cote
 * Date: 11 feb 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto.request;

import java.io.Serializable;

/**
 * 
 */
public class RoleUpdateRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleUpdateRequestDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
