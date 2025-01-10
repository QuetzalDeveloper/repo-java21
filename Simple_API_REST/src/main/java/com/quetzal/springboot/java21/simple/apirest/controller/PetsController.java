package com.quetzal.springboot.java21.simple.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quetzal.springboot.java21.simple.apirest.dto.PetDTO;
import com.quetzal.springboot.java21.simple.apirest.service.PetsServiceI;

@RestController
public class PetsController {
	
	@Autowired
	private PetsServiceI service;
	
	@GetMapping("/getPets")
	public ResponseEntity<Object> getPets () {
		try {
			List<PetDTO> pets = service.getPets();
			return ResponseEntity.ok(pets);
		} catch (Exception e) {
			throw e;
		}
	}

}
