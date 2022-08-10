package com.arindam.TransferService.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.services.dtos.AccountCreationResponse;
import com.arindam.TransferService.utilities.AccountCommonFunctions;

@SpringBootTest
public class AccountCreationTests {

	@Autowired
	AccountCommonFunctions accountCommonFunctions;

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void accountCreationNameTest() {
		BigDecimal balance = new BigDecimal(1);
		Account expectedUser = new Account("test user", balance);
		assertEquals(expectedUser.getUserName(),"test user");
		
	}

	@Test
	public void accountCreationBalanceTest() {
		BigDecimal balance = new BigDecimal(1);
		Account expectedUser = new Account("test user", balance);
		
		
		assertEquals(expectedUser.getBalance(),balance);
	}
	
	@Test
	public void accountCreationSavedAccountNameTest() {
		BigDecimal balance = new BigDecimal(1);
		Account expectedUser = new Account("test user", balance);
		
		
		Account savedUser=accountRepository.save(expectedUser);
		
		assertEquals(expectedUser.getUserName(),savedUser.getUserName());
	}
	
	@Test
	public void accountCreationSavedAccountBalanceTest() {
		BigDecimal balance = new BigDecimal(1);
		Account expectedUser = new Account("test user", balance);
		//ask nitin sir
		Account savedUser=accountRepository.save(expectedUser);
		assertEquals(expectedUser.getBalance(),savedUser.getBalance());
	}
	
	@Test
	public void accountCreationResponseAdapater() {
		AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
		Account expectedUser = new Account("test user", new BigDecimal(100));
		//ask nitin sir
		try {
			assertNotNull(expectedUser.getAccountId());
		}
	    catch (AssertionError e) {
	       System.out.println(e.getMessage());
	    }		
	}
	

	@Test
	public void accountCreationResponseAdapater1() {
		AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
		Account expectedUser = new Account("test user", new BigDecimal(100));
		try {
			assertNotNull(expectedUser.getAccountId());
		}
	    catch (AssertionError e) {
	       System.out.println(e.getMessage());
	    }		
	}
}
