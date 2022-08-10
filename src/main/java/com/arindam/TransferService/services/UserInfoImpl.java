package com.arindam.TransferService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.TransferService.constants.BalanceResponse;
import com.arindam.TransferService.dtos.UserDetailsResponse;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.utilities.ReponseCommonFunction;

@Service
public class UserInfoImpl implements UserInfo{

	@Autowired
	AccountRepository accountRepository; 
	
	
	@Override
	public UserDetailsResponse getBalance(Long accountId) {
		try{
			UserDetailsResponse userDetailsResponse=new UserDetailsResponse();
			
			if(accountId==null) {
				userDetailsResponse.setResponse(BalanceResponse.INVALID_INPUT.getMessage());
				userDetailsResponse.setStatusCode(BalanceResponse.INVALID_INPUT.getCode());
				return userDetailsResponse;
			}
			Account userAccount=accountRepository.findByAccountId(accountId);
		
			if(Account.isNull(userAccount)) {
				userDetailsResponse.setResponse(BalanceResponse.INVALID_INPUT.getMessage());
				userDetailsResponse.setStatusCode(BalanceResponse.INVALID_INPUT.getCode());
				return userDetailsResponse;
			}
			ReponseCommonFunction responseCommonFunction=new ReponseCommonFunction();
			userDetailsResponse=responseCommonFunction.mapResponse(userAccount);
			userDetailsResponse.setResponse(BalanceResponse.BALANCE_CHECK_SUCCESSFUL.getMessage());
			userDetailsResponse.setStatusCode(BalanceResponse.BALANCE_CHECK_SUCCESSFUL.getCode());
			return userDetailsResponse;
		}
		catch (Exception ex) {
			UserDetailsResponse userDetailsResponse=new UserDetailsResponse();
			userDetailsResponse.setResponse(BalanceResponse.BALANCE_CHECK_FAILURE.getMessage());
			userDetailsResponse.setStatusCode(BalanceResponse.BALANCE_CHECK_FAILURE.getCode());
			return userDetailsResponse;
		}
	}

	

}
