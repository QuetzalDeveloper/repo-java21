/**
 * Classname: RoleDaoImp.java
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

import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.utils.Utils;

@Component
public class RoleDaoImp implements RoleDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImp.class);
	
	private static final String GET_ROLES = "SELECT r.id, desc_key, r.created_date, r.active, admin_id, account FROM users.role r join users.admin a ON r.admin_id = a.id ";
	
	@Autowired
	javax.sql.DataSource dataSource;
	
	public RoleDaoImp() {
		super();
	}

	@Override
	public List<RoleResponseDTO> getRoles(Integer active) throws AppException {
		List<RoleResponseDTO> response = new ArrayList<>();;
		StringBuilder sb = new StringBuilder(GET_ROLES);
		
		if(active == 1) {	//Active roles
			sb.append(" WHERE r.active = true"); 
		}else if(active == 2) {	//Inactive roles
			sb.append(" WHERE r.active = false");
		}
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sb.toString());
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				RoleResponseDTO role = new RoleResponseDTO();
				role.setId(res.getInt(1));
				role.setDescKey(res.getString(2));
				role.setCreateDate(Utils.timestampToString(res.getTimestamp(3)));
				role.setActive(res.getBoolean(4));
				role.setAdminId(res.getInt(5));
				role.setAdminAccount(res.getString(6));
				response.add(role);
			}
			
			LOGGER.info("Response roles = {}", response);
			
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return response;
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
