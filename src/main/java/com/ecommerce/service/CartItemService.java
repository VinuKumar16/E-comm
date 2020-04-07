package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartItemDao;
import com.ecommerce.model.CartItem;

@Service
public class CartItemService {

	@Autowired
	private CartItemDao dao;

	public CartItem save(CartItem entity) {
		return dao.save(entity);
	}

	public void delete(CartItem entity) {
		dao.delete(entity);
	}

	public void deleteAll() {
		dao.deleteAll();
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

}
