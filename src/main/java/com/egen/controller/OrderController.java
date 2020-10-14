package com.egen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egen.exception.DataNotFoundException;
import com.egen.model.Orders;
import com.egen.repository.AccountRepository;
import com.egen.repository.OrderRepository;

@Controller 
@RequestMapping(path="/ecommerce/orders") 
public class OrderController {
	
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired 
	private AccountRepository accountRepository;
	
	
	@PostMapping("/{accountId}/add")
	public ResponseEntity<String> addNewOrder(@PathVariable(value = "accountId") Integer accountId, @RequestBody Orders orderDetails) 
			throws DataNotFoundException{
		return accountRepository.findById(accountId).map(accountHolder -> {
			orderDetails.setAccountId(accountHolder);
			orderRepository.save(orderDetails);
			return ResponseEntity.ok("Order is placed");
        }).orElseThrow(() -> new DataNotFoundException("Error in order placement! Try again."));

	}
		
	@DeleteMapping("{orderId}/delete")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) throws DataNotFoundException  {
		
		orderRepository.deleteById(orderId);
		return ResponseEntity.ok("Order Deleted");
	}
	
	@GetMapping("/{orderId}/view")
	@ResponseBody
	public Optional<Orders> getAddressessByAccount(@PathVariable Integer orderId) throws DataNotFoundException {
		return orderRepository.findById(orderId);				
	}

}
