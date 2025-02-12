/**
 * Classname: RoleDTO.java
 * Author: Diego Hernandez Cote
 * Date: 11 feb 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 */
public class RoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descKey;
	private LocalDateTime createdDate;
	private boolean active;
	private Integer adminId;
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescKey() {
		return descKey;
	}
	public void setDescKey(String descKey) {
		this.descKey = descKey;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", descKey=" + descKey + ", createdDate=" + createdDate + ", adminId=" + adminId
				+ ", active=" + active + ", description=" + description + "]";
	}
}
