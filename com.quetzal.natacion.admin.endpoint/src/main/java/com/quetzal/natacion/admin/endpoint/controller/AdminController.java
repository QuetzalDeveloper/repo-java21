/**
 * Classname: AdminController.java
 * Author: Diego Hernandez Cote
 * Date: 14 feb 2025
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quetzal.natacion.admin.endpoint.dto.request.AdminRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.AdminResponseDTO;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.service.AdminService;

/**
 * 
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/getAdmins")
	public ResponseEntity<?> getAdmins(@RequestHeader("adminId") Integer adminId, @RequestParam("active") Integer active) throws AppException {
		try {
			List<AdminResponseDTO> response = service.getAdmins(adminId, active);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getErrorMessage());
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/newAdmin")
	public ResponseEntity<?> insertAdmin(@RequestHeader("adminId") Integer adminId, @RequestBody AdminRequestDTO request) throws AppException {
		try {
			List<AdminResponseDTO> response = service.insertAdmin(adminId, request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (AppException e) {
			LOGGER.error("{}", e.getErrorMessage());
			LOGGER.error("{}", e.getMessage());
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
