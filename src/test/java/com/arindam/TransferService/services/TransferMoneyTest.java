package com.arindam.TransferService.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.arindam.TransferService.constants.TranscationResponse;
import com.arindam.TransferService.dtos.TransferMoneyRequest;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.utilities.AccountCommonFunctions;

@ExtendWith(MockitoExtension.class)
public class TransferMoneyTest {

	@Mock
	AccountRepository accountRepository;

	@Mock
	AccountCommonFunctions accountCommonFunctions;
	
	@InjectMocks
	TransferMoneyImpl transferMoneyImpl=new TransferMoneyImpl();
	
	
	@Test
	public void successfullTransaction() {
		//high balance account transferring low amount of money
		Mockito.when(accountRepository.findByAccountId(1L)).thenReturn(sourceAccount(highBalance()));
		Mockito.when(accountRepository.findByAccountId(2L)).thenReturn(destAccount());
		Mockito.when(accountCommonFunctions.checkMinimumTransactionBalance(sourceAccount(highBalance()), lowBalance())).thenReturn(true);
		
		Mockito.doNothing().when(accountCommonFunctions).transferBalance(sourceAccount(highBalance()), destAccount(), lowBalance());
				
		TranscationResponse expectedResponse=transferMoneyImpl.transfer(1L,createPassRequest(lowBalance()));
		assertEquals(expectedResponse,TranscationResponse.TRANSACTION_SUCCESSFUL);
	}

	@Test
	public void invalidTransaction() {
		TranscationResponse expectedResponse=transferMoneyImpl.transfer(1L,createInvalidRequest());
		assertEquals(expectedResponse,TranscationResponse.INVALID_TRANSACTION);
	}
	
	@Test
	public void invalidAccountTransaction() {
		TranscationResponse expectedResponse=transferMoneyImpl.transfer(1L,createInvalidAccountRequest());
		assertEquals(expectedResponse,TranscationResponse.INVALID_TRANSACTION);
	}
	
	private TransferMoneyRequest createInvalidAccountRequest() {
		TransferMoneyRequest transferMoneyReq=new TransferMoneyRequest();
		transferMoneyReq.setDestAccountNum(2L);
		transferMoneyReq.setAmount(null);
		return transferMoneyReq;
	}

	private TransferMoneyRequest createInvalidRequest() {
		return null;
	}

	@Test
	public void lowBalanceTransaction() {
		//low balance account transferring high amount of money
		Mockito.when(accountRepository.findByAccountId(1L)).thenReturn(sourceAccount(lowBalance()));
		Mockito.when(accountRepository.findByAccountId(2L)).thenReturn(destAccount());
		Mockito.when(accountCommonFunctions.checkMinimumTransactionBalance(sourceAccount(lowBalance()), highBalance())).thenReturn(false);
		
				
		TranscationResponse expectedResponse=transferMoneyImpl.transfer(1L,createPassRequest(highBalance()));
		assertEquals(expectedResponse,TranscationResponse.INSUFFICIENT_AMOUNT);
	}

	private Account sourceAccount(BigDecimal balance) {
		return new Account("test user 1",balance);
	}
	private Account destAccount() {
		return new Account("test user 2",new BigDecimal(5000));
	}
	
	private TransferMoneyRequest createPassRequest(BigDecimal balance) {
		TransferMoneyRequest transferMoneyReq=new TransferMoneyRequest();
		transferMoneyReq.setDestAccountNum(2L);
		transferMoneyReq.setAmount(balance);
		return transferMoneyReq;
	}
	
	public BigDecimal highBalance() {
		return new BigDecimal(2000);
	}
	public BigDecimal lowBalance() {
		return new BigDecimal(200);
	}
	

	
	
 
}
