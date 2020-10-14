package com.egen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egen.model.Account;
import com.egen.repository.AccountRepository;

@Controller 
@RequestMapping(path="/ecommerce") 
public class AccountController {


	@Autowired 
	private AccountRepository customerRepository;

	@PostMapping("/account")
	public ResponseEntity<String> addNewOrder(@RequestBody Account newCutomer)  {
		customerRepository.save(newCutomer);
		return ResponseEntity.ok("Account Created");
	}


	@GetMapping("/all")
	public @ResponseBody Iterable<Account> getAllUsers() {
		return customerRepository.findAll();
	}
}
