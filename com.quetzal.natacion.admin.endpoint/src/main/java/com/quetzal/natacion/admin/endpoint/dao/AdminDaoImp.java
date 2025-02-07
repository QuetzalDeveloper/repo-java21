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
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.quetzal.natacion.admin.endpoint.dto.AdminDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;

@Component
public class AdminDaoImp implements AdminDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminDaoImp.class);
	
	private static final String VALIDATE_ADMIN = "SELECT id, name, role_id FROM users.admin WHERE id = ?";
	
	@Autowired
	javax.sql.DataSource dataSource;
	
	public AdminDaoImp() {
		super();
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
	
	private void close(Connection connection) {
		try {
			if(Objects.nonNull(connection) && !connection.isClosed()) {
				connection.close();
			}
		}catch(SQLException e) {
			LOGGER.error("Error to close connection");
		}
	}
	
}
