/**
 * Classname: RoleServiceImp.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quetzal.natacion.admin.endpoint.dao.RoleDao;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

@Component
public class RoleServiceImp implements RoleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImp.class);
	
	@Autowired
	private AdminService adminService;
	
	@Autowired 
	private RoleDao dao;

	@Override
	public List<RoleResponseDTO> getRoles(Integer adminId, Integer active) throws AppException {
		LOGGER.info("[adminId = {}]. GetRoles. Active = {}", adminId, active);
		
		adminService.validateAdmin(adminId);
		
		List<RoleResponseDTO> response = dao.getRoles(active);
		
		return response;
	}

}
