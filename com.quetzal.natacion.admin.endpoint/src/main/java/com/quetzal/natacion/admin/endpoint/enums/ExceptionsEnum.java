/**
 * Classname: ExceptionsEnum.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.enums;

public enum ExceptionsEnum {

		ERROR_UNEXPECTED_EXCEPTION("ERROR_UNEXPECTED_EXCEPTION", "error.unexpected_exception"),
		ERROR_INVALID_PARAMETER("ERROR_INVALID_PARAMETER", "error.invalid_parameter"),
		ERROR_DATES_INVALIDS("ERROR_DATES_INVALIDS", "error.invalid_dates"),
		ERROR_ADMIN_ID_INVALID("ERROR_ADMIN_ID_INVALID", "error.invalid.adminId"),
		ERROR_DATABASE_PROCESS("ERROR_DATABASE_PROCESS", "error.database.process");
		
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
