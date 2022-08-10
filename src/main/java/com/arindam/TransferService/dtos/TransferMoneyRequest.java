package com.arindam.TransferService.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;

@Data	
public class TransferMoneyRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4824756504942177660L;
	
	public Long destAccountNum;
	public BigDecimal amount;
	
}
