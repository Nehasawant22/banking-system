package com.banking.service;

import java.util.List;

import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.exception.AccountException;
import com.banking.exception.CustomerException;

public interface CustomerService {

	public List<Account> getCurrentBalanceByCustomerId(Long customerId);

	public Account getCurrentBalanceByCustomerIdAndAccountNo(Long customerId, long accountNumber);

	public Customer updateCustomerDetails(Customer customer);

	public String updateLoanAccountStatus(Long customerId, long accountNumber);

	public String deleteAccount(Long customerId, long accountNumber) throws CustomerException, AccountException;

	public List<Customer> getAllAccountDetails();

	String addCustomer(Customer customer) throws CustomerException;
}
