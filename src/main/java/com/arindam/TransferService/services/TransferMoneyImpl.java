package com.arindam.TransferService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.TransferService.constants.TranscationResponse;
import com.arindam.TransferService.dtos.TransferMoneyRequest;
import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;
import com.arindam.TransferService.utilities.AccountCommonFunctions;

@Service
public class TransferMoneyImpl implements TransferMoney {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountCommonFunctions accountCommonFunctions;

	public TranscationResponse transfer(Long sourceAccountNum, TransferMoneyRequest transferMoneyRequestBody) {
		// TODO Auto-generated method stub
		if (sourceAccountNum == null || transferMoneyRequestBody == null
				|| transferMoneyRequestBody.getDestAccountNum() == null || transferMoneyRequestBody.getAmount() == null) {
			return TranscationResponse.INVALID_TRANSACTION;
		}

		Account sourceAccount = accountRepository.findByAccountId(sourceAccountNum);
		Account destAccount = accountRepository.findByAccountId(transferMoneyRequestBody.destAccountNum);

		try {
			if (Account.isNull(sourceAccount) || Account.isNull(destAccount))
				return TranscationResponse.INVALID_TRANSACTION;

			if (accountCommonFunctions.checkMinimumTransactionBalance(sourceAccount, transferMoneyRequestBody.amount)) {
				accountCommonFunctions.transferBalance(sourceAccount, destAccount, transferMoneyRequestBody.amount);
				return TranscationResponse.TRANSACTION_SUCCESSFUL;
			} else
				return TranscationResponse.INSUFFICIENT_AMOUNT;

		} catch (Exception ex) {
			return TranscationResponse.TRANSFER_FAILURE;
		}
	}

}
