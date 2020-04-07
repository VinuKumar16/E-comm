package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {


}
