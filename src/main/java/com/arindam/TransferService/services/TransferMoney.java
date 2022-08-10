package com.arindam.TransferService.services;

import com.arindam.TransferService.constants.TranscationResponse;
import com.arindam.TransferService.dtos.TransferMoneyRequest;

public interface TransferMoney {
	TranscationResponse transfer(Long sourceAccountNum, TransferMoneyRequest transferMoneyRequestBody);
}
