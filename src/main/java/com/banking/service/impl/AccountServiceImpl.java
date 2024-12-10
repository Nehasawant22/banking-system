package com.banking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;

import jakarta.transaction.Transactional;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public String creditAmountToAccount(Long accountNumber, Long creditAmount) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if(accountOptional.isPresent()) {
			Long updatedBalance=accountOptional.get().getCurrentBalance()+creditAmount;
			accountOptional.get().setCurrentBalance(updatedBalance);
			accountRepository.save(accountOptional.get());
			return "Balance :"+updatedBalance;
		}
		return "account not exist";
	}
	
	@Override
	public String withdrawAmountFromAccount(Long accountNumber, Long debitAmount) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if(accountOptional.isPresent()) {
			Long updatedBalance=accountOptional.get().getCurrentBalance()+debitAmount;
			accountOptional.get().setCurrentBalance(updatedBalance);
			accountRepository.save(accountOptional.get());
			return "Balance :"+updatedBalance;
		}
		return "account not exist";
	}
}
