/**
 * Classname: AuthResponse.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.dto.response;

import java.io.Serializable;

/**
 *
 */
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
