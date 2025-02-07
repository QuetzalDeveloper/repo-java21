/**
 * Classname: RoleService.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import java.util.List;

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
	
}
