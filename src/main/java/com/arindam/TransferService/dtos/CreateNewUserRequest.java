package com.arindam.TransferService.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateNewUserRequest {
	String name;
	BigDecimal balance;
	public static boolean isNull(CreateNewUserRequest obj) {
	    return obj == null;
	}

}
