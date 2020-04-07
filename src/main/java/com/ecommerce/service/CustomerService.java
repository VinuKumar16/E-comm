package com.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public Customer save(Customer entity) {
		return dao.save(entity);
	}

	public void deleteById(Integer id) {
		dao.deleteById(id);
	}

	public Optional<Customer> findById(Integer id) {
		return dao.findById(id);
	}
	
	

}
