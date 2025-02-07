/**
 * Classname: RoleResponseDTO.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RoleResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descKey;
	private String createDate;
	private boolean active;
	private Integer adminId;
	private String adminAccount;
	
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	
	@Override
	public String toString() {
		return "RoleResponse [id=" + id + ", descKey=" + descKey + ", createDate=" + createDate + ", active=" + active
				+ ", adminId=" + adminId + ", adminAccount=" + adminAccount + "]";
	}
	
}
