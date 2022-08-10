package com.arindam.TransferService.services.dtos;

import com.arindam.TransferService.constants.CreationResponse;

import lombok.Data;

@Data
public class AccountCreationResponse {
	String response;
	Long accountId;
	Integer statusCode;
}
