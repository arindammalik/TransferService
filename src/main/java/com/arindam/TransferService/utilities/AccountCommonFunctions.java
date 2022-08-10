package com.arindam.TransferService.utilities;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arindam.TransferService.entities.Account;
import com.arindam.TransferService.repos.AccountRepository;

@Component
public class AccountCommonFunctions {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void addBalance(Account sourceAccount, BigDecimal balance) {
		sourceAccount.setBalance(sourceAccount.getBalance().add(balance));
		this.saveUser(sourceAccount);
	}
	
	public void reduceBalance(Account sourceAccount, BigDecimal balance) {
		sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
		this.saveUser(sourceAccount);
	}
	
	@Transactional
	public void transferBalance(Account sourceAccount, Account destAccount, BigDecimal balance) {
		reduceBalance(sourceAccount,balance);
		addBalance(destAccount,balance);
		
	}

    public long saveUser(Account newUser){
		newUser=accountRepository.save(newUser);
		return newUser.getAccountId();
    }

	public boolean checkMinimumTransactionBalance(Account sourceAccount, BigDecimal amount) {
		return sourceAccount.getBalance().compareTo(amount)>=0?true:false;
	}
}
