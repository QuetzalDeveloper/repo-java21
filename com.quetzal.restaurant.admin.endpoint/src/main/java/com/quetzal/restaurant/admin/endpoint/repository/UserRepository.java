/**
 * Classname: UserRepository.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quetzal.restaurant.admin.endpoint.model.User;

/**
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String usename);
}
