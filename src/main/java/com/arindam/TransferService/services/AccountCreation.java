package com.arindam.TransferService.services;

import com.arindam.TransferService.dtos.CreateNewUserRequest;
import com.arindam.TransferService.services.dtos.AccountCreationResponse;

public interface AccountCreation {
	AccountCreationResponse createAccount(CreateNewUserRequest createNewUserRequest);
}
