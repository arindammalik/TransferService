package com.arindam.TransferService.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.TransferService.constants.CreationResponse;
import com.arindam.TransferService.dtos.CreateNewUserRequest;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.services.dtos.AccountCreationResponse;

@Service
public class AccountCreationImpl implements AccountCreation {


	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountCreationResponse createAccount(CreateNewUserRequest createNewUserRequest) {
		try {
			AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
			if(invalidInput(createNewUserRequest)) {
				accountCreationResponse.setResponse(CreationResponse.INVALID_INPUT.getMessage());
				accountCreationResponse.setStatusCode(CreationResponse.INVALID_INPUT.getCode());
				return accountCreationResponse;
			}
			
			Account newUser = new Account(createNewUserRequest.getName(), createNewUserRequest.getBalance());		
			Long id=accountRepository.save(newUser).getAccountId();
			accountCreationResponse.setAccountId(id);
			accountCreationResponse.setResponse(CreationResponse.CREATION_SUCCESSFUL.getMessage());
			accountCreationResponse.setStatusCode(CreationResponse.CREATION_SUCCESSFUL.getCode());
			return accountCreationResponse;
			
		}
		catch (Exception ex) {
			AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
			accountCreationResponse.setResponse(CreationResponse.CREATION_FAILURE.getMessage());
			accountCreationResponse.setStatusCode(CreationResponse.CREATION_FAILURE.getCode());
			return accountCreationResponse;
		}
	}

	private boolean invalidInput(CreateNewUserRequest createNewUserRequest) {
		if (CreateNewUserRequest.isNull(createNewUserRequest) ||
				createNewUserRequest.getName()==null ||
				createNewUserRequest.getName().equals("") || createNewUserRequest.getName().equals(null) ||
					createNewUserRequest.getBalance()==null ||
					!(createNewUserRequest.getBalance() instanceof BigDecimal)
				)
			return true;
		return false;
	}

}
