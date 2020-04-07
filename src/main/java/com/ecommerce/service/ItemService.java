package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ItemDao;
import com.ecommerce.model.Item;

@Service
public class ItemService {

	@Autowired
	private ItemDao dao;

	public Item save(Item item) {
		return dao.save(item);
	}

	public List<Item> findAll() {
		return dao.findAll();
	}

	public Optional<Item> findById(Integer id) {
		return dao.findById(id);
	}

}
