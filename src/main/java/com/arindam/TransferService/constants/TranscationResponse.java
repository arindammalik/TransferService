package com.arindam.TransferService.constants;

public enum TranscationResponse {
	TRANSACTION_SUCCESSFUL("Successful", 200), TRANSFER_FAILURE("Failed, please retry", 500),
	INVALID_TRANSACTION("Invalid Input", 400), INSUFFICIENT_AMOUNT("Insufficient Money in source account", 400);

	String message;
	int code;

	TranscationResponse(String message, int code) {
		this.message = message;
		this.code = code;
	}

}
