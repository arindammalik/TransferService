package com.arindam.TransferService.constants;

import lombok.Getter;

@Getter
public enum CreationResponse {
	CREATION_SUCCESSFUL("Successful", 200), INVALID_INPUT("Invalid Input", 400), CREATION_FAILURE("Failed, please retry", 500);

	String message;
	int code;
	
	CreationResponse(String message, int code) {
		this.message = message;
		this.code = code;
	}
}
