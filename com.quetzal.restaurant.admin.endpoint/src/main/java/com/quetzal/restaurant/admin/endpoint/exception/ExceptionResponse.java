/**
 * Classname: ExceptionResponse.java
 * Author: Diego Hernandez Cote
 * Date: 11 feb 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.exception;

/**
 * 
 */
public class ExceptionResponse {
	
	private Integer status;
	private String errorCode;
	private String errorMessageKey;
	private String error;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessageKey() {
		return errorMessageKey;
	}
	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "ExceptionResponse [status=" + status + ", errorCode=" + errorCode + ", errorMessageKey="
				+ errorMessageKey + ", error=" + error + "]";
	}

}
