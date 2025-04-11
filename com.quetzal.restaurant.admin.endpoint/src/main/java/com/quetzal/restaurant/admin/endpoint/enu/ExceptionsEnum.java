/**
 * Classname: ExceptionsEnum.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.enu;

public enum ExceptionsEnum {

		ERROR_UNEXPECTED_EXCEPTION("ERROR.UNEXPECTED_EXCEPTION", "error.unexpected_exception"),
		ERROR_DATABASE_PROCESS("ERROR.DATABASE_PROCESS", "error.database.process"), 
		//General
		ERROR_INVALID_PARAMETER("ERROR.INVALID.PARAMETER", "error.invalid.parameter"),
		ERROR_INVALID_DATES("ERROR.INVALID.DATES", "error.invalid.dates"),
		ERROR_INVALID_ADMIN_ID("ERROR.INVALID.USER_ID", "error.invalid.userId"),
		
		//User
		ERROR_INVALID_USERNAME("ERROR.INVALID.USERNAME", "error.invalid.username"),
		ERROR_INVALID_NAME("ERROR.INVALID.NAME", "error.invalid.name"),
		ERROR_INVALID_LASTNAME("ERROR.INVALID.LASTNAME", "error.invalid.lastname"),
		ERROR_INVALID_PASSWORD("ERROR.INVALID.PASSWORD", "error.invalid.password"),
		ERROR_INVALID_EMAIL("ERROR.INVALID.EMAIL", "error.invalid.email"),
		ERROR_INVALID_TELEPHONE("ERROR.INVALID.TELEPHONE", "error.invalid.telephone"),
		ERROR_INVALID_BIRTHDATE("ERROR.INVALID.BIRTHDATE", "error.invalid.birthdate"),
		;
		
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
