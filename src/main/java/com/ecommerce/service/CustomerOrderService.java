package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CustomerOrderDao;
import com.ecommerce.model.CustomerOrder;

@Service
public class CustomerOrderService {

	@Autowired
	private CustomerOrderDao dao;

	public CustomerOrder save(CustomerOrder entity) {
		return dao.save(entity);
	}
	

}
