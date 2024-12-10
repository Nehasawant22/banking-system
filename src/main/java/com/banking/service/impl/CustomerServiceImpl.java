package com.banking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.exception.AccountException;
import com.banking.exception.CustomerException;
import com.banking.repository.AccountRepository;
import com.banking.repository.CustomerRepository;
import com.banking.service.CustomerService;

import jakarta.transaction.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		
		Optional<Customer> custOpt=customerRepository.findById(customer.getCustomerId());
		if (custOpt.isPresent()) {
			if (customer.getAccounts().stream().anyMatch(cust -> cust.getAccountTypes().equalsIgnoreCase("savings")) 
					&& custOpt.get().getAccounts().stream().anyMatch(cust -> cust.getAccountTypes().equalsIgnoreCase("savings")))
				throw new CustomerException("Customer can't create more than one savings acoount");
			if (customer.getAccounts().stream().anyMatch(cust -> cust.getAccountTypes().equalsIgnoreCase("loan"))
					&& custOpt.get().getAccounts().stream().anyMatch(cust -> cust.getAccountTypes().equalsIgnoreCase("loan")))
				throw new CustomerException("Customer can't create more than one loan acoount");

		}

		customerRepository.save(customer);
		return "Customer details saved successfully";
	}

	@Override
	public List<Account> getCurrentBalanceByCustomerId(Long customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
//		String resp = "";
		List<Account> accounts =new ArrayList<>();
		if (customerOptional.isPresent()) {
			Customer cust = customerOptional.get();

			 accounts = cust.getAccounts();
//			if (null != accounts && !accounts.isEmpty()) {
//				for (Account acc : accounts) {
//					resp = resp + acc.getAccountTypes() + ":" + acc.getCurrentBalance() + "\n";
//				}
//			}
			
		}
		return accounts;
	}

	@Override
	public String getCurrentBalanceByCustomerIdAndAccountNo(Long customerId, long accountNumber) {
		String resp = "";
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent() && accountOptional.isPresent()) {
			resp = resp + customerOptional.get().getCustomerName() + " : " + accountOptional.get().getCurrentBalance()
					+ "\n";
		}

		return resp;
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		Optional<Customer> customerOptional = customerRepository.findById(customer.getCustomerId());
		
		if (customerOptional.isPresent()) {

			customerRepository.save(customer);
		}
		return customer;
	}

	@Override
	public String updateLoanAccountStatus(Long customerId, long accountNumber) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isPresent() && accountOptional.isPresent()) {
			accountOptional.get().setLoanStatus("closed");
			accountRepository.save(accountOptional.get());
			return "loan status updated successfully";
		} else {
			return "account Doeas not exists";
		}
	}

	@Override
	public String deleteAccount(Long customerId, long accountNumber) throws CustomerException, AccountException {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		Customer customerOptional = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerException("Please Enter Valid Customer Id"));
		if (accountOptional.isPresent()) {
			accountRepository.delete(accountOptional.get());
			return "Account Deleted Successfully for customer :" + customerId;
		}
		throw new AccountException("Account number or CustomerId does not exixts in the database");
	}

	@Override
	public List<Customer> getAllAccountDetails() {
		List<Customer> customers = customerRepository.findAll();
		List<Customer> customerlst = new ArrayList<>();
		for (Customer customer : customers) {
			Customer custom = new Customer();
			custom.setCustomerName(customer.getCustomerName());

		}
		return customers;
	}

}
