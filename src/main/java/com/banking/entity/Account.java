package com.banking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {
	
	private String accountTypes;
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 private Long accountNumber;
	 private long currentBalance;
	 private String loanStatus;
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="account_id")
	 @JsonIgnore
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
	public Account(String accountTypes, Long accountNumber, long currentBalance, String loanStatus, Customer customer) {
		super();
		this.accountTypes = accountTypes;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.loanStatus = loanStatus;
		this.customer = customer;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountTypes=" + accountTypes + ", accountNumber=" + accountNumber + ", currentBalance="
				+ currentBalance + ", loanStatus=" + loanStatus + "]";
	}
	
	

}
