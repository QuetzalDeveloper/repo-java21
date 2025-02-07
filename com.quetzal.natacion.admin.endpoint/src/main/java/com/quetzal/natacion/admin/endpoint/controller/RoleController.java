/**
 * Classname: RoleController.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	@GetMapping("/getRole")
	public ResponseEntity<?> getRoles(@RequestHeader("adminId")Integer adminId, @RequestParam("active") Integer active) throws AppException{
		try {
			List<RoleResponseDTO> response = service.getRoles(adminId, active);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
					ExceptionsEnum.ERROR_UNEXPECTED_EXCEPTION);
		}
	}
}
