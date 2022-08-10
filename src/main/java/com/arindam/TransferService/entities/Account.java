package com.arindam.TransferService.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{
	
	public Account(String name, BigDecimal balance2) {
		// TODO Auto-generated constructor stub
		this.balance=balance2;
		this.userName=name;
	}
	public Account() {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1752042073432563204L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;	

	@Version
	private Integer version;
	
	@Column(name = "name")
	private String userName;
	
	@Column(name = "balance")
	private BigDecimal balance;
	
	 public static boolean isNull(Account obj) {
	     return obj == null;
	 }
}
