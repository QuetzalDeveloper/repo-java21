/**
 * Classname: UserController.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.controller;

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

import com.quetzal.restaurant.admin.endpoint.dto.request.UserRequest;
import com.quetzal.restaurant.admin.endpoint.exception.AppException;
import com.quetzal.restaurant.admin.endpoint.service.UserService;

/**
 * 
 */
@RestController
@RequestMapping("/restaurant/user") 
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestHeader Long userId, @RequestParam Long id) throws AppException {
		try {
			return new ResponseEntity<>(userService.getUser(userId, id), HttpStatus.OK);
		}catch (AppException e) {
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/newUser")
    public ResponseEntity<?> newUser(@RequestHeader Long userId, @RequestBody UserRequest request) throws AppException {
        try {
            return new ResponseEntity<>(userService.insertUser(userId, request), HttpStatus.OK);
        } catch (AppException e) {
        	return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestHeader Long userId, @RequestBody UserRequest request, @RequestParam Long id) throws AppException {
		try {
			return new ResponseEntity<>(userService.updateUser(userId, request, id), HttpStatus.OK);
		} catch (AppException e) {
			return new ResponseEntity<>(e.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
