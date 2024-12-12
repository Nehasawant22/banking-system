package com.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.exception.AccountException;
import com.banking.exception.CustomerException;
import com.banking.service.AccountService;
import com.banking.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value ="/customer")
	public  ResponseEntity<String> addCustomer(@RequestBody Customer customerDto) throws CustomerException {
		
		for(Account acc: customerDto.getAccounts()) {
			acc.setCustomer(customerDto);
		}

		String resp=customerService.addCustomer(customerDto);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> getAllAccountDetails(){
		List<Customer> resp = customerService.getAllAccountDetails();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@GetMapping(value = "/customer/{custId}")
	public ResponseEntity<List<Account>> getCurrentBalancebyCustId(@PathVariable  Long custId){
		List<Account> resp = customerService.getCurrentBalanceByCustomerId(custId);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	@GetMapping(value = "/customer/{custId}/{accNo}")
	public ResponseEntity<Account> getCurrentBalanceByCustomerIdAndAccountNo(@PathVariable  Long custId, @PathVariable  Long accNo){
		Account resp = customerService.getCurrentBalanceByCustomerIdAndAccountNo(custId,accNo);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@PutMapping(value = "/customer/{accountNumber}/{creditAmount}")
	public ResponseEntity<String> creditAmountToAccount(@PathVariable Long accountNumber, @PathVariable Long creditAmount) {
		String resp= accountService.creditAmountToAccount(accountNumber, creditAmount);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@PutMapping(value = "/customer/debit/{accountNumber}/{debitAmount}")
	public ResponseEntity<String> withdrawAmountFromAccount(@PathVariable Long accountNumber, @PathVariable Long debitAmount) {
		String resp= accountService.withdrawAmountFromAccount(accountNumber, debitAmount);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@PutMapping(value = "/customer/updatecustomer")
	public ResponseEntity<Customer> updateCustomerDetails(@RequestBody Customer customer) {
		for(Account acc: customer.getAccounts()) {
			acc.setCustomer(customer);
		}
		Customer resp=customerService.updateCustomerDetails(customer);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@PutMapping(value = "/customer/loanStatus/{customerId}/{accountNumber}")
	public ResponseEntity<String> updateLoanAccountStatus(@PathVariable Long customerId,@PathVariable long accountNumber ){
		String resp= customerService.updateLoanAccountStatus(customerId, accountNumber);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/customer/{customerId}/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long customerId, @PathVariable long accountNumber) throws CustomerException,AccountException{
		String resp= customerService.deleteAccount(customerId, accountNumber);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
}
