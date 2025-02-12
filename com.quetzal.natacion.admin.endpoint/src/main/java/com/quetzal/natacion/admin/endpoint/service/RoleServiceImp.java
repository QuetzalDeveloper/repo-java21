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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.quetzal.natacion.admin.endpoint.dao.RoleDao;
import com.quetzal.natacion.admin.endpoint.dto.RoleDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleUpdateRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.utils.Utils;

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
		
		if(Utils.isNullOrLessThan1(active)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The param active is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_PARAM_ACTIVE);
		}
		
		adminService.validateAdmin(adminId);
		
		List<RoleResponseDTO> response = dao.getRoles(active);
		
		return response;
	}

	@Override
	public Integer insertRole(Integer adminId, RoleRequestDTO request) throws AppException {
		LOGGER.info("[adminId = {}]. Insert role = {}", adminId, request);
		
		adminService.validateAdmin(adminId);
		
		if(Utils.isNullOrEmpty(request.getName())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The role name is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_NAME);
		} else {
			request.setName(request.getName().toUpperCase());
		}
		
		int res = dao.insertRole(adminId, request);
		
		return 0;
		
	}

	@Override
	public Integer activeRole(Integer adminId, Integer roleId, boolean active) throws AppException {
		LOGGER.info("[adminId = {}]. Active role {} = {}", adminId, roleId, active);
		adminService.validateAdmin(adminId);		
		
		if(Utils.isNullOrEmpty(roleId)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The roleId is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_ID);
		}
		if(Utils.isNullOrEmpty(active)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The role active is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_PARAM_ACTIVE);
		}
		RoleDTO role = dao.findRoleById(roleId);
		
		if(Utils.isNullOrEmpty(role)) {
			throw new AppException(HttpStatus.CONFLICT.value(), "The roleId is invalid or not exists",ExceptionsEnum.ERROR_INVALID_ROLE_ID);
		}
		
		if(role.isActive() != active) {
			dao.activeRole(roleId, active);
		}
		return 0;
	}

	@Override
	public Integer updateRole(Integer adminId, RoleUpdateRequestDTO request) throws AppException {
		LOGGER.info("[adminId = {}]. Update role = {}", adminId, request);
		
		if(Utils.isNullOrEmpty(request)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The role request is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_REQUEST);
		}
		if(Utils.isNullOrLessThan1(request.getId())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The roleId is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_ID);
		}
		if(Utils.isNullOrEmpty(request.getName())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The role name is invalid",ExceptionsEnum.ERROR_INVALID_ROLE_NAME);
		}
		request.setName(request.getName().toUpperCase());
		adminService.validateAdmin(adminId);
		dao.updateRole(request);
		
		return 0;
	}

}
