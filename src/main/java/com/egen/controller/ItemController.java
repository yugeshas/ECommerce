package com.egen.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.egen.model.Item;
import com.egen.repository.ItemRepository;

@Controller 
@RequestMapping(path="/ecommerce/products") 
public class ItemController {
	
	
	@Autowired 
	private ItemRepository itemRepository;
	
	
	@PostMapping("/item")
	public ResponseEntity<String> addNewItem(@RequestBody Item newItem) {
		itemRepository.save(newItem);
		return ResponseEntity.ok("New product added!");
	}
}
