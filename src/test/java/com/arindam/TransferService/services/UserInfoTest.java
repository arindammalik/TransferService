package com.arindam.TransferService.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.arindam.TransferService.constants.BalanceResponse;
import com.arindam.TransferService.dtos.UserDetailsResponse;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class UserInfoTest {

	@Mock
	AccountRepository accountRepository;


	@InjectMocks
	UserInfo userInfoImpl=new UserInfoImpl();
	
	@Test
	public void passRequestTest() {
		this.mockRepoSave();
		Long inputRequest=createPassRequest();	
		UserDetailsResponse accountCreationResponse =userInfoImpl.getBalance(inputRequest);
		
		UserDetailsResponse expectedUserDetailsResponse=new UserDetailsResponse();
		expectedUserDetailsResponse.setName("test user");
		expectedUserDetailsResponse.setBalance(new BigDecimal(1000));
		expectedUserDetailsResponse.setResponse(BalanceResponse.BALANCE_CHECK_SUCCESSFUL.getMessage());
		expectedUserDetailsResponse.setStatusCode(BalanceResponse.BALANCE_CHECK_SUCCESSFUL.getCode());
		assertEquals(accountCreationResponse, expectedUserDetailsResponse);
	}
	
	@Test
	public void passFailedTest() {
		Long inputRequest=createFailedRequest();	
		UserDetailsResponse accountCreationResponse =userInfoImpl.getBalance(inputRequest);
		
		UserDetailsResponse expectedUserDetailsResponse=new UserDetailsResponse();
		expectedUserDetailsResponse.setName(null);
		expectedUserDetailsResponse.setBalance(null);
		expectedUserDetailsResponse.setResponse(BalanceResponse.INVALID_INPUT.getMessage());
		expectedUserDetailsResponse.setStatusCode(BalanceResponse.INVALID_INPUT.getCode());
		assertEquals(accountCreationResponse, expectedUserDetailsResponse);
	}

	private Long createPassRequest() {
		//mock input
		return 1L;
	}
	private Long createFailedRequest() {
		//mock input
		return null;
	}
	

	private void mockRepoSave() {
		Account userAccount=new Account("test user",new BigDecimal(1000));
		Mockito.when(accountRepository.findByAccountId(Mockito.any())).thenReturn(userAccount);
	}

	



}
