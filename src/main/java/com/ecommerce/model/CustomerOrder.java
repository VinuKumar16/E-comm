package com.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderId", scope = CustomerOrder.class)
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@OneToOne
	private Customer customer;

	@OneToOne
	@JsonIgnore
	private Cart cart;

	@OneToOne
	private Address address;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Cart getCart() {
		return cart;
	}

	public Address getAddress() {
		return address;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
