package com.arindam.TransferService.services;

import com.arindam.TransferService.dtos.UserDetailsResponse;

public interface UserInfo {
	UserDetailsResponse getBalance(Long accountId);
}
