/**
 * Classname: UserRepository.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quetzal.restaurant.admin.endpoint.model.User;

/**
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.active=true")
    Optional<User> getByUsernameAndActive(String username);
	
	Optional<User> findByUsername(String username);

    Optional<User> findByTelephone(String telephone);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.active=:active")
	List<User> getUsersByActive(boolean active);
    
    @Query("SELECT COUNT(1) FROM User u WHERE u.username=:username")
    Integer getCountByUsername(String username);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.active=:active WHERE id=:id")
    int updateActiveUser(Long id, boolean active);
}
