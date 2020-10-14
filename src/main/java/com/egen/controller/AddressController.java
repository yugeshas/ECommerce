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
import com.egen.model.Address;
import com.egen.repository.AccountRepository;
import com.egen.repository.AddressRepository;

@Controller 
@RequestMapping(path="/ecommerce/address") 
public class AddressController {
	
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired 
	private AccountRepository accountRepository;
	
	@PostMapping("/{accountId}/add")
	public ResponseEntity<String> addAddress(@PathVariable(value = "accountId") Integer accountId, @RequestBody Address newAddress) 
			throws DataNotFoundException{
		return accountRepository.findById(accountId).map(accountHolder -> {
			newAddress.setAccountId(accountHolder);
			//setAccountId(accountHolder);
            addressRepository.save(newAddress);
            return ResponseEntity.ok("New address added");
        }).orElseThrow(() -> new DataNotFoundException("Error while adding new address! Try again"));

	}
	
	
	@DeleteMapping("/{addId}/delete")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer addId) {
		addressRepository.deleteById(addId);
	    return ResponseEntity.ok("Address is deleted!");
	}
	
	

}
