/**
 * Classname: AdminService.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import java.util.List;

import com.quetzal.natacion.admin.endpoint.dto.request.AdminRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.AdminResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface AdminService {

	/**
	 * Validate if the adminId exists
	 * @param adminId
	 * @throws AppException
	 */
	public void validateAdmin(Integer adminId) throws AppException;

	/**
	 * Get the basic data for the list of admins
	 * @param adminId
	 * @param active
	 * @return
	 */
	public List<AdminResponseDTO> getAdmins(Integer adminId, Integer active) throws AppException;

	/**
	 * Insert the data for a new admin
	 * @param adminId
	 * @param request
	 * @return
	 */
	public List<AdminResponseDTO> insertAdmin(Integer adminId, AdminRequestDTO request);

}
