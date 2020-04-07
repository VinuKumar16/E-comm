
package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Integer> {

}
