package com.arindam.TransferService.utilities;

import com.arindam.TransferService.dtos.UserDetailsResponse;
import com.arindam.TransferService.entities.Account;

public class ReponseCommonFunction {

	public UserDetailsResponse mapResponse(Account userAccount) {
		
		UserDetailsResponse userDetailsResponse=new UserDetailsResponse();
		
		userDetailsResponse.setBalance(userAccount.getBalance());
		userDetailsResponse.setName(userAccount.getUserName());
		
		return userDetailsResponse;
	}
}
