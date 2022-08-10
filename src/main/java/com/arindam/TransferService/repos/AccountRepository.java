package com.arindam.TransferService.repos;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.arindam.TransferService.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccountId(Long accountId);
	
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	Account save(Account account);
	
}
