package com.ecommerce.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CartDao;
import com.ecommerce.model.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao dao;

	public Cart save(Cart entity) {
		return dao.save(entity);
	}

	public Optional<Cart> findById(Integer id) {
		return dao.findById(id);
	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = findById(cartId).orElse(null);
		if (cart == null || cart.getCartItems().size() == 0)
			throw new IOException("Cart not found for cart id " + cartId);
		return cart;

	}

}
