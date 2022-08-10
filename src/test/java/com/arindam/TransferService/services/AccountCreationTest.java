package com.arindam.TransferService.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.arindam.TransferService.constants.CreationResponse;
import com.arindam.TransferService.dtos.CreateNewUserRequest;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.services.dtos.AccountCreationResponse;

@ExtendWith(MockitoExtension.class)
public class AccountCreationTest {

	@Mock
	AccountRepository accountRepository;

	
	@InjectMocks
	AccountCreation accountCreationImpl=new AccountCreationImpl();
	
	static Long PASS_ACCOUNT_ID=1L;
	static Long FAILED_ACCOUNT_ID=2L;
	
	@Test
	public void passRequestTest() {
		this.mockRepoSave();
		CreateNewUserRequest inputRequestBody=createPassRequest();	
		AccountCreationResponse accountCreationResponse =accountCreationImpl.createAccount(inputRequestBody);
		
		AccountCreationResponse expectedAccount=new AccountCreationResponse();
		expectedAccount.setAccountId(PASS_ACCOUNT_ID);
		expectedAccount.setResponse(CreationResponse.CREATION_SUCCESSFUL.getMessage());
		expectedAccount.setStatusCode(CreationResponse.CREATION_SUCCESSFUL.getCode());
		assertEquals(accountCreationResponse, expectedAccount);
	}

	private CreateNewUserRequest createPassRequest() {
		//mock input
		CreateNewUserRequest inputRequestBody=new CreateNewUserRequest();
		inputRequestBody.setBalance(new BigDecimal(1));
		inputRequestBody.setName("test user");
		return inputRequestBody;
	}
	

	@Test
	public void InvalidRequestTest() {
		CreateNewUserRequest inputRequestBody=createInvalidRequest();	
		AccountCreationResponse accountCreationResponse =accountCreationImpl.createAccount(inputRequestBody);
		
		AccountCreationResponse expectedAccount=new AccountCreationResponse();
		expectedAccount.setAccountId(null);
		expectedAccount.setResponse(CreationResponse.INVALID_INPUT.getMessage());
		expectedAccount.setStatusCode(CreationResponse.INVALID_INPUT.getCode());

		
		assertEquals(accountCreationResponse, expectedAccount);
	}
	
	private CreateNewUserRequest createInvalidRequest() {
		//mock input
		CreateNewUserRequest inputRequestBody=new CreateNewUserRequest();
		return inputRequestBody;
	}
	
	private void mockRepoSave() {
		Account userAccount=new Account("test user",new BigDecimal(1));
		userAccount.setAccountId(PASS_ACCOUNT_ID);
		Mockito.when(accountRepository.save(Mockito.any())).thenReturn(userAccount);
	}

	

}
