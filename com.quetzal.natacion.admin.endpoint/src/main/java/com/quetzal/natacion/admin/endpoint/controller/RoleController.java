/**
 * Classname: RoleController.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quetzal.natacion.admin.endpoint.dto.request.RoleRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleUpdateRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService service;
	
	@GetMapping("/getRole")
	public ResponseEntity<?> getRoles(@RequestHeader("adminId")Integer adminId, @RequestParam("active") Integer active) throws AppException{
		try {
			List<RoleResponseDTO> response = service.getRoles(adminId, active);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/newRole")
	public ResponseEntity<?> insertRole(@RequestHeader("adminId") Integer adminId, @RequestBody RoleRequestDTO request ) throws AppException {
		try {
			Integer response = service.insertRole(adminId, request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/activeRole")
	public ResponseEntity<?> activeRole(@RequestHeader("adminId") Integer adminId, @RequestParam("roleId")Integer roleId, @RequestParam("action")boolean active) throws AppException {
		try {
			Integer response = service.activeRole(adminId, roleId, active);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateRole")
	public ResponseEntity<?> updateRole(@RequestHeader("adminId") Integer adminId, @RequestBody RoleUpdateRequestDTO request) throws AppException {
		try {
			Integer response = service.updateRole(adminId, request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
