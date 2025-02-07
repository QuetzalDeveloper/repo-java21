/**
 * Classname: AppException.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.exception;

import com.quetzal.natacion.admin.endpoint.enums.ExceptionsEnum;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Integer status;
	private final String errorCode;
	private final String errorMessage;
	private final String errorMessageKey;
	
	public AppException(Integer status, String errorCode, String errorMessage, String errorMessageKey) {
		super(errorMessage);
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorMessageKey = errorMessageKey;
	}
	
	public AppException(Integer status, String errorMessage, ExceptionsEnum errorServicesEnum) {
		this(status, errorServicesEnum.getErrorCode(), errorMessage, errorServicesEnum.getErrorMessageKey());
	}
	
	public Integer getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorMessageKey() {
		return errorMessageKey;
	}
}
