package com.dxctraining.customermgt.customer.service;
import com.dxctraining.customermgt.customer.dao.ICustomerDao;
import com.dxctraining.customermgt.customer.entities.*;
import com.dxctraining.customermgt.customer.exceptions.CustomerNotFoundException;
import com.dxctraining.customermgt.customer.exceptions.InvalidArgumentException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao dao;
	
	@Override
	public Customer save(Customer customer) {
		validate(customer);
		customer=dao.save(customer);
		return customer;
		
	}
	
	public void validate(Customer customer) {
		if(customer == null) {
			throw new InvalidArgumentException("customer cant be null ");
			}
	}
	@Override
	public Customer findById(Integer id) {
		Optional<Customer> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new CustomerNotFoundException("customer not found for id=" + id);
		}
		Customer customer = optional.get();
		return customer;
	}
	
	@Override
	public List<Customer> findByName(String name) {
		
		List list = dao.findByName(name);
		return list;	
	}
	
	@Override
	public List<Customer> findAll() {
		List list =dao.findAll();
		return list;
	}
	

	
	
}
