/**
 * Classname: ExceptionsEnum.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.enums;

public enum ExceptionsEnum {

		ERROR_UNEXPECTED_EXCEPTION("ERROR_UNEXPECTED_EXCEPTION", "error.unexpected_exception"),
		ERROR_DATABASE_PROCESS("ERROR_DATABASE_PROCESS", "error.database.process"), 
		//General
		ERROR_INVALID_PARAMETER("ERROR_INVALID_PARAMETER", "error.invalid.parameter"),
		ERROR_INVALID_DATES("ERROR_INVALID_DATES", "error.invalid.dates"),
		ERROR_INVALID_ADMIN_ID("ERROR_INVALID_ADMIN_ID", "error.invalid.adminId"),
		
		//ROLE
		ERROR_INVALID_ROLE_NAME("ERROR_INVALID_ROLE_NAME", "error.invalid.role.name"), 
		ERROR_INVALID_ROLE_ID("ERROR_INVALID_ROLE_ID", "error.invalid.role.id"), 
		ERROR_INVALID_ROLE_PARAM_ACTIVE("ERROR_INVALID_ROLE_PARAM_ACTIVE", "error.invalid.role.param.active"), 
		ERROR_INVALID_ROLE_REQUEST("ERROR_INVALID_ROLE_REQUEST", "error.invalid.role.request");
		
		private String errorCode;
		private String errorMessageKey;

		ExceptionsEnum(String errorCode, String errorMessageKey) {
			this.errorCode = errorCode;
			this.errorMessageKey = errorMessageKey;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorMessageKey() {
			return errorMessageKey;
		}

}
