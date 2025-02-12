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

import com.quetzal.natacion.admin.endpoint.dto.RoleDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.request.RoleUpdateRequestDTO;
import com.quetzal.natacion.admin.endpoint.dto.response.RoleResponseDTO;
import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;
import com.quetzal.natacion.admin.endpoint.exception.AppException;
import com.quetzal.natacion.admin.endpoint.utils.Utils;

@Component
public class RoleDaoImp implements RoleDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImp.class);
	
	private static final String GET_ROLES = "SELECT r.id, desc_key, r.created_date, r.active, admin_id, account, description FROM users.role r join users.admin a ON r.admin_id = a.id ";
	private static final String FIND_ROLE_BY_ID ="SELECT id, desc_key, created_date, active, admin_id, description FROM users.role WHERE id = ?";
	private static final String INSERT_ROLE = "INSERT INTO users.role (desc_key, created_date, active, admin_id, description) VALUES(?, now(), true, ?, ?)";
	private static final String UPDATE_ROLE_ACTIVE = "UPDATE users.role SET active = ? WHERE id = ?";
	private static final String UPDATE_ROLE = "UPDATE users.role SET desc_key = ?, description=? WHERE id = ?";
	
	@Autowired
	javax.sql.DataSource dataSource;
	
	public RoleDaoImp() {
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
				role.setDescription(res.getString(7));
				response.add(role);
			}
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return response;
	}

	@Override
	public int insertRole(Integer adminId, RoleRequestDTO request) throws AppException {
		Connection connection = null;
		Integer value = 0;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_ROLE);
			ps.setString(1, request.getName());
			ps.setInt(2, adminId);
			ps.setString(3, request.getDescription());
			
			boolean res = ps.execute();
			
			if(!res) {
				value = 1;
			}
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return value;
	}

	@Override
	public RoleDTO findRoleById(Integer roleId) throws AppException {
		RoleDTO response = null;
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(FIND_ROLE_BY_ID);
			ps.setInt(1, roleId);
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				response = new RoleDTO();
				response.setId(res.getInt(1));
				response.setDescKey(res.getString(2));
				response.setCreatedDate(res.getTimestamp(3).toLocalDateTime());
				response.setActive(res.getBoolean(4));
				response.setAdminId(res.getInt(5));
				response.setDescription(res.getString(6));
			}
		}catch(Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
		return response;
	}

	@Override
	public void activeRole(Integer roleId, boolean active) throws AppException {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_ROLE_ACTIVE);
			ps.setBoolean(1, active);
			ps.setInt(2, roleId);
			ps.execute();
		}catch (Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
	}

	@Override
	public void updateRole(RoleUpdateRequestDTO request) throws AppException {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_ROLE);
			ps.setString(1, request.getName());
			ps.setString(2, request.getDescription());
			ps.setInt(3, request.getId());
			ps.execute();
		}catch (Exception e) {
			throw new AppException(HttpStatus.CONFLICT.value(), e.getMessage(),ExceptionsEnum.ERROR_DATABASE_PROCESS);
		}finally {
			close(connection);
		}
	}
}
