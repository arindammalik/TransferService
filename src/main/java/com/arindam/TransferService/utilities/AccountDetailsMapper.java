package com.arindam.TransferService.utilities;

import org.mapstruct.Mapper;

import com.arindam.TransferService.dtos.UserDetailsResponse;
import com.arindam.TransferService.entities.Account;

@Mapper
public interface AccountDetailsMapper {
	UserDetailsResponse getUserDetail(Account account);

}
