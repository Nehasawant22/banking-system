package com.banking.service;

public interface AccountService {
	
	public String creditAmountToAccount(Long accountNumber, Long creditAmount ) ; 

	public String withdrawAmountFromAccount(Long accountNumber, Long debitAmount ) ; 
 
}
