/**
 * Classname: AdminDao.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dao;

import com.quetzal.natacion.admin.endpoint.dto.AdminDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface AdminDao {

	/**
	 * Return the admin data from DB if exists
	 * @param adminId
	 * @return
	 * @throws AppException
	 */
	public AdminDTO validateAdmin(Integer adminId) throws AppException;
	
	

}
