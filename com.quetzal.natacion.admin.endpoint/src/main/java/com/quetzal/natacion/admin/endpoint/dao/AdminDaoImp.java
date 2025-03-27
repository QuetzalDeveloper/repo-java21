/**
 * Classname: AdminDaoImp.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.quetzal.natacion.admin.endpoint.dto.AdminDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.AdminResponseDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

@Component
public class AdminDaoImp implements AdminDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDaoImp.class);
	
	private static final String VALIDATE_ADMIN = "SELECT id, name, role_id FROM users.admin WHERE id = ?";
	private static final String GET_ADMINS = "SELECT a.id, a.email, a.account, a.name, a.last_name, a.phone_number, r.id, r.desc_key FROM users.admin a join users.role r on a.role_id = r.id";
	
	@Autowired
	javax.sql.DataSource dataSource;
	
	public AdminDaoImp() {
		super();
	}
	
	private void close(Connection connection) {
		try {
			if(Objects.nonNull(connection) && !connection.isClosed()) {
				connection.close();
			}
		}catch(SQLException e) {
			LOGGER.error("Error to close connection");
		}
	}

	@Override
	public AdminDTO validateAdmin(Integer adminId) throws AppException {
		AdminDTO admin = null;
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(VALIDATE_ADMIN);
			ps.setInt(1, adminId);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				admin = new AdminDTO();
				admin.setId(res.getInt(1));
				admin.setName(res.getString(2));
				admin.setRole(res.getInt(3));
			}
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return admin;
	}

	@Override
	public List<AdminResponseDTO> getAdmins(Integer adminId, Integer active) throws AppException {
		List<AdminResponseDTO> response = new ArrayList<>();
		StringBuilder sb = new StringBuilder(GET_ADMINS);
		
		if(active == 1) {	//Active admins
			sb.append(" WHERE a.active = true");
		} else if(active ==2) {		//Inactive admins
			sb.append(" WHERE a.active = false");
		}
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sb.toString());
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				AdminResponseDTO admin = new AdminResponseDTO();
				admin.setId(res.getInt(1));
				admin.setEmail(res.getString(2));
				admin.setAccount(res.getString(3));;
				admin.setName(res.getString(4));
				admin.setLastName(res.getString(5));
				admin.setPhoneNumber(res.getString(6));
				admin.setRoleId(res.getInt(7));
				admin.setRoleName(res.getString(8));
				response.add(admin);
			}
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return response;
	}
	
}
