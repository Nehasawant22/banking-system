package com.banking.dto;

import java.util.List;

import com.banking.entity.Account;
import com.banking.entity.Customer;

public class CustomerDTO {
	private Long Id;
	private String customerName;
private List<AccountDTO> accounts;
	
	
	public List<AccountDTO> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
//	public Customer prepareCustomer(CustomerDTO customerDTO) {
//		for(AccountDTO accountDTO : customerDTO.getAccounts()) {
//			Account accounts=new Account(accountDTO.getAccountTypes(), accountDTO.getAccountNumber(), accountDTO.getCurrentBalance(), accountDTO.getLoanStatus(), null)
//		}
//	}

}
