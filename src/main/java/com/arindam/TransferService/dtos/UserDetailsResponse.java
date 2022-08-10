package com.arindam.TransferService.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserDetailsResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3380409768686314798L;
	String name;
	BigDecimal balance;
	public static boolean isNull(UserDetailsResponse userDetails) {
		return userDetails == null;
	}
	
	String response;
	Integer statusCode;
	
}
