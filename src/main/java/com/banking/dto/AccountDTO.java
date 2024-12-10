package com.banking.dto;

import com.banking.entity.Customer;

public class AccountDTO {
 private String accountTypes;
 private Long accountNumber;
 private long currentBalance;
 private String loanStatus;
 private Customer customer;
 
 
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
public String getAccountTypes() {
	return accountTypes;
}
public void setAccountTypes(String accountTypes) {
	this.accountTypes = accountTypes;
}
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public long getCurrentBalance() {
	return currentBalance;
}
public void setCurrentBalance(long currentBalance) {
	this.currentBalance = currentBalance;
}
public String getLoanStatus() {
	return loanStatus;
}
public void setLoanStatus(String loanStatus) {
	this.loanStatus = loanStatus;
}
 
}
