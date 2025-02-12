/**
 * Classname: RoleService.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import java.util.List;

import com.quetzal.natacion.admin.endpoint.dto.request.RoleRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleUpdateRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface RoleService {

	/**
	 * Get the list of user roles. 
	 * Param active: 0= all, 1= active, 2= inactive
	 * @param adminId
	 * @param active
	 * @return List<RoleResponse>
	 */
	public List<RoleResponseDTO> getRoles(Integer adminId, Integer active) throws AppException;

	/**
	 * Insert a new user role
	 * @param adminId
	 * @param request
	 * @return
	 */
	public Integer insertRole(Integer adminId, RoleRequestDTO request) throws AppException;

	/**Active (true) or inactive (false) a role
	 * @param adminId
	 * @param roleId
	 * @param active
	 * @return
	 */
	public Integer activeRole(Integer adminId, Integer roleId, boolean active) throws AppException;

	/**Update some role data
	 * @param adminId
	 * @param request
	 * @return
	 */
	public Integer updateRole(Integer adminId, RoleUpdateRequestDTO request) throws AppException;
	
}
