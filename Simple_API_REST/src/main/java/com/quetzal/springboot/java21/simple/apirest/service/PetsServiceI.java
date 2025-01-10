package com.quetzal.springboot.java21.simple.apirest.service;

import java.util.List;

import com.quetzal.springboot.java21.simple.apirest.dto.PetDTO;

public interface PetsServiceI {

	List<PetDTO> getPets();
	

}
