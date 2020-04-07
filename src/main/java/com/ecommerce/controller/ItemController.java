package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Item;
import com.ecommerce.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;

	@PostMapping("/item")
	public Item saveItem(@RequestBody Item item) {
		return service.save(item);

	}

	@GetMapping("/items")
	public List<Item> getAllBooks() {
		return service.findAll();

	}

}
