package com.arindam.TransferService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.TransferService.dtos.CreateNewUserRequest;
import com.arindam.TransferService.dtos.UserDetailsResponse;
import com.arindam.TransferService.services.AccountCreation;
import com.arindam.TransferService.services.UserInfo;
import com.arindam.TransferService.services.dtos.AccountCreationResponse;

@RestController
@RequestMapping("/userDetails")
public class UserDetails {
	
	@Autowired
	AccountCreation accountCreationImpl;
	
	@Autowired
	UserInfo userInfoImpl;
	
	@PostMapping("/v1/createNewUser")
	public ResponseEntity<AccountCreationResponse> createNewUser(
			@RequestBody CreateNewUserRequest createNewUserRequest
			){
		AccountCreationResponse newAccountResponse=accountCreationImpl.createAccount(createNewUserRequest);
		return new ResponseEntity<>(newAccountResponse, HttpStatus.OK);
		
	}
	
	@GetMapping("/v1/getBalance/{accountId}")
	public ResponseEntity<?> getBalance(
			@PathVariable Long accountId
			){
		UserDetailsResponse userDetails=userInfoImpl.getBalance(accountId);
		if(UserDetailsResponse.isNull(userDetails))
			return new ResponseEntity<>(userDetails, HttpStatus.BAD_REQUEST); 
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
}
