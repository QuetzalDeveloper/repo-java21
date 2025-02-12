/**
 * Classname: RoleDao.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dao;

import java.util.List;

import com.quetzal.natacion.admin.endpoint.dto.RoleDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleUpdateRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface RoleDao {

	List<RoleResponseDTO> getRoles(Integer active) throws AppException;

	int insertRole(Integer adminId, RoleRequestDTO request) throws AppException;

	RoleDTO findRoleById(Integer roleId) throws AppException;

	void activeRole(Integer roleId, boolean active) throws AppException;

	void updateRole(RoleUpdateRequestDTO request) throws AppException;

}
