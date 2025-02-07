/**
 * Classname: AdminService.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface AdminService {

	/**
	 * Validate if the adminId exists
	 * @param adminId
	 * @throws AppException
	 */
	public void validateAdmin(Integer adminId) throws AppException;

}
