/**
 * Classname: AdminServiceImp.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.quetzal.natacion.admin.endpoint.dao.AdminDao;
import com.quetzal.natacion.admin.endpoint.dto.AdminDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.utils.Utils;

@Component
public class AdminServiceImp implements AdminService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImp.class);
	
	@Autowired
	private AdminDao dao;
	
	@Override
	public void validateAdmin(Integer adminId) throws AppException {
		
		if(Utils.isNullOrLessThan1(adminId)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "Invalid adminId = " + adminId,ExceptionsEnum.ERROR_INVALID_ADMIN_ID);
		}
		
		AdminDTO admin = dao.validateAdmin(adminId);
		
		if(Utils.isNullOrEmpty(admin)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "adminId not found or not exists = " + adminId,ExceptionsEnum.ERROR_INVALID_ADMIN_ID);
		} else {
			LOGGER.info("{}",admin);
		}
		
	}

}
