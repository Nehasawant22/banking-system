package com.banking.service;

public interface AccountService {
	
	public Long creditAmountToAccount(Long accountNumber, Long creditAmount ) ; 

	public Long withdrawAmountFromAccount(Long accountNumber, Long debitAmount ) ; 
 
}
