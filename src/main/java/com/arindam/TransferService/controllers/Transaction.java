package com.arindam.TransferService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.TransferService.constants.TranscationResponse;
import com.arindam.TransferService.dtos.TransferMoneyRequest;
import com.arindam.TransferService.services.TransferMoney;

@RestController
@RequestMapping("/transaction")
public class Transaction {

	@Autowired
	TransferMoney transferMoneyImpl;

	@PostMapping("/v1/transferMoney/{sourceAccountNum}")
	public ResponseEntity<?> transferMoney(@RequestBody TransferMoneyRequest transferMoneyRequest,
			@PathVariable Long sourceAccountNum
			
			) {
		TranscationResponse transactionResponse=transferMoneyImpl.transfer(sourceAccountNum, transferMoneyRequest);
		return ResponseEntity.ok().body(transactionResponse);
	}
	
	
	
}
