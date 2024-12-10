package com.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BankingSystemExceptionHandler {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<?> handleCustomerNotFoundException(CustomerException customernotFoundExc,WebRequest req){
		ErrorDetails details=new ErrorDetails();
		details.setStatusCode(HttpStatus.NOT_FOUND.value());
		details.setMessage(customernotFoundExc.getMessage());
		details.setDetails(req.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<?> handleAccountNotFoundException(AccountException accountnotFoundExc,WebRequest req){
		ErrorDetails details=new ErrorDetails();
		details.setStatusCode(HttpStatus.NOT_FOUND.value());
		details.setMessage(accountnotFoundExc.getMessage());
		details.setDetails(req.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
