package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.CustomerOrder;

@Service
public class OrderService {

	@Autowired
	private OrderDao dao;

	public List<CustomerOrder> findAll() {
		return dao.findAll();
	}
	
	
}
