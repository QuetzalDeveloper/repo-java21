/**
 * Classname: RoleDao.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dao;

import java.util.List;

import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

public interface RoleDao {

	List<RoleResponseDTO> getRoles(Integer active) throws AppException;

}
