package com.egen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egen.exception.DataNotFoundException;
import com.egen.model.Payment;
import com.egen.repository.AccountRepository;
import com.egen.repository.PaymentRepository;

@Controller 
@RequestMapping(path="/ecommerce/payments") 
public class PaymentController {
	
	
	@Autowired 
	private PaymentRepository paymentRepository;
	
	@Autowired 
	private AccountRepository accountRepository;
		
	@PostMapping("/{accountId}/add")
	public ResponseEntity<String> addNewPayMethod(@PathVariable(value = "accountId") Integer accountId, @RequestBody Payment payDetails) 
			throws DataNotFoundException{
		return accountRepository.findById(accountId).map(accountHolder -> {
			payDetails.setAccountId(accountHolder);
			paymentRepository.save(payDetails);
            return ResponseEntity.ok("New payment method addedd!");
        }).orElseThrow(() -> new DataNotFoundException("Error while adding new payment method! Try again"));

	}
	
	@DeleteMapping("/{paymentId}/delete")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer paymentId) {
		paymentRepository.deleteById(paymentId);
	    return ResponseEntity.ok("Payment method deleted!");
	}

}
