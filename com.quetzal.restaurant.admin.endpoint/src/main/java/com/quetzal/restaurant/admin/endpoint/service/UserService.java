/**
 * Classname: UserService.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quetzal.restaurant.admin.endpoint.dto.request.UserRequest;
import com.quetzal.restaurant.admin.endpoint.enu.ExceptionsEnum;
import com.quetzal.restaurant.admin.endpoint.enu.Role;
import com.quetzal.restaurant.admin.endpoint.exception.AppException;
import com.quetzal.restaurant.admin.endpoint.model.User;
import com.quetzal.restaurant.admin.endpoint.repository.UserRepository;
import com.quetzal.restaurant.admin.endpoint.utils.Utils;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.getByUsernameAndActive(username);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
    
    public List<User> getUser(Long userId, Long id) throws AppException{
    	List<User> users = new ArrayList<>();
		if(id == 0) {	//All users
			users = userRepository.findAll();
		} else if(id == -1) {	//Active
			users = userRepository.getUsersByActive(true);
		} else if(id == -2) {	//Inactive
			users = userRepository.getUsersByActive(false);
		} else {
			users = userRepository.findById(id).stream().collect(Collectors.toList());
		}
  
		return users;
	}

	public User insertUser(Long userId, UserRequest request) throws AppException {
		if(Utils.isNullOrEmpty(request)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The request is null", ExceptionsEnum.ERROR_INVALID_PARAMETER); 
		}
		
		validateUserRequest(request);
		validateUserExists(request);
		
		User user = new User();
		user.setUsername(request.getUsername());
		user.setName(request.getName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());
		user.setCreatedDate(LocalDateTime.now());
		user.setRole(Role.valueOf(request.getRole()));
		user.setTelephone(request.getTelephone());
		user.setBirthDate(Utils.stringToLocalDateTime(request.getBirthdate()));
		user.setEmail(request.getEmail());
		user.setActive(true);;
		
		return userRepository.save(user);
	}
	
	public Object updateUser(Long userId, UserRequest request, Long id) throws AppException{
		
		if(Utils.isNullOrEmpty(request)) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The request is null", ExceptionsEnum.ERROR_INVALID_PARAMETER); 
		}
		
		Optional<User> original = userRepository.findById(id);
		
		if(original.isEmpty()) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The user not exists", ExceptionsEnum.ERROR_INVALID_PARAMETER);
		}
		
		validateUserRequest(request);
		validateUserUpdate(original.get(), request);
		
		User user = new User();
		user.setId(id);
		user.setUsername(request.getUsername());
		user.setName(request.getName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());
		user.setCreatedDate(LocalDateTime.now());
		user.setRole(Role.valueOf(request.getRole()));
		user.setTelephone(request.getTelephone());
		user.setBirthDate(Utils.stringToLocalDateTime(request.getBirthdate()));
		user.setEmail(request.getEmail());
		user.setActive(true);;
		
		return userRepository.save(user);
	}

	public Integer activeUser(Long userId, Long id, boolean active) throws AppException {
		validateUserExists(id);
		return userRepository.updateActiveUser(id, active);
	}

	private void validateUserExists(Long id) throws AppException {
		if (userRepository.findById(id).isEmpty()) {
			throw new AppException(HttpStatus.CONFLICT.value(), "The user not exists",
					ExceptionsEnum.ERROR_EXISTS_USERNAME);
		}
	}

	private void validateUserUpdate(User original, UserRequest request) throws AppException{
		if (!original.getUsername().equals(request.getUsername())) {
			if (userRepository.findByUsername(original.getUsername()).isPresent()) {
				throw new AppException(HttpStatus.CONFLICT.value(), "The username already exists",
						ExceptionsEnum.ERROR_EXISTS_USERNAME);
			}
		}
	}

	private void validateUserExists(UserRequest request) throws AppException {
		if(userRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new AppException(HttpStatus.CONFLICT.value(), "The username already exists", ExceptionsEnum.ERROR_EXISTS_USERNAME); 
		}
		
		if(!Utils.isNullOrEmpty(request.getTelephone())) {
			if(userRepository.findByTelephone(request.getTelephone()).isPresent()) {
				throw new AppException(HttpStatus.CONFLICT.value(), "The phone number already exists", ExceptionsEnum.ERROR_EXISTS_TELEPHONE);
			}
		}
		
		if(!Utils.isNullOrEmpty(request.getEmail())) {
			if(userRepository.findByEmail(request.getEmail()).isPresent()) {
				throw new AppException(HttpStatus.CONFLICT.value(), "The email number already exists", ExceptionsEnum.ERROR_EXISTS_EMAIL);
			}
		}
	}

	private void validateUserRequest(UserRequest request) throws AppException {
		if(Utils.isNullOrEmpty(request.getUsername())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The username is invalid", ExceptionsEnum.ERROR_INVALID_USERNAME); 
		} else if(Utils.isNullOrEmpty(request.getName())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The username is invalid", ExceptionsEnum.ERROR_INVALID_NAME);
		}  else if(Utils.isNullOrEmpty(request.getLastName())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The lastname is invalid", ExceptionsEnum.ERROR_INVALID_LASTNAME);
		}  else if(Utils.isNullOrEmpty(request.getPassword())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The password is invalid", ExceptionsEnum.ERROR_INVALID_PASSWORD);
		}  else if(!Utils.isNullOrEmpty(request.getEmail()) && !Utils.isEmail(request.getEmail())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The email is invalid", ExceptionsEnum.ERROR_INVALID_EMAIL);
		}  else if(!Utils.isNullOrEmpty(request.getTelephone()) && !Utils.isPhoneNumber(request.getTelephone())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The phone number is invalid", ExceptionsEnum.ERROR_INVALID_TELEPHONE);
		}  else if(!Utils.isNullOrEmpty(request.getBirthdate()) && !Utils.isDate(request.getBirthdate())) {
			throw new AppException(HttpStatus.BAD_REQUEST.value(), "The birthdate is invalid", ExceptionsEnum.ERROR_INVALID_BIRTHDATE);
		}
	}

}
