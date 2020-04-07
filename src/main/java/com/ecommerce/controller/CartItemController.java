package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Item;
import com.ecommerce.service.CartItemService;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CustomerService;
import com.ecommerce.service.ItemService;

@RestController
public class CartItemController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemService itemService;

	@GetMapping("/user/cart/add")
	public void addCartItem(@RequestParam(value = "productId") int productId,
			@RequestParam(value = "customerId") int customerId) {
		Customer customer = customerService.findById(customerId).orElse(null);
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		Item item = itemService.findById(productId).orElse(null);
		for (int i = 0; i < cartItems.size(); i++) {
			CartItem cartItem = cartItems.get(i);
			if (item.getItemId() == cartItem.getItem().getItemId()) {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getItem().getPrice());
				cartItemService.save(cartItem);
				return;
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setItem(item);
		cartItem.setTotalPrice(item.getPrice() * 1);
		cartItem.setCart(cart);
		cartItemService.save(cartItem);
	}

	@GetMapping("/user/cart/removeCartItem/{cartItemId}")
	public void removeCartItem(@PathVariable(value = "cartItemId") int cartItemId) {
		cartItemService.deleteById(cartItemId);
	}

	@GetMapping("/user/cart/removeAllItems/{cartId}")
	public void removeAllCartItems(@PathVariable(value = "cartId") int cartId) {
		Optional<Cart> cart = cartService.findById(cartId);
		List<CartItem> cartItems = cart.get().getCartItems();
		for (CartItem cartItem : cartItems) {
			cartItemService.deleteById(cartItem.getCartItemId());
		}
	}
}
