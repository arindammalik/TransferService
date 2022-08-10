package com.arindam.TransferService.constants;

import lombok.Getter;

@Getter
public enum BalanceResponse {
	BALANCE_CHECK_SUCCESSFUL("Successful", 200), INVALID_INPUT("Invalid Input", 400), BALANCE_CHECK_FAILURE("Failed, please retry", 500);

	String message;
	int code;
	
	BalanceResponse(String message, int code) {
		this.message = message;
		this.code = code;
	}
}
