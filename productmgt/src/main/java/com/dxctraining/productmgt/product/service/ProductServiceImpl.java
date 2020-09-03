package com.dxctraining.productmgt.product.service;
import com.dxctraining.productmgt.product.dao.IProductDao;
import com.dxctraining.productmgt.product.entities.*;
import com.dxctraining.productmgt.product.exceptions.ProductNotFoundException;
import com.dxctraining.productmgt.product.exceptions.InvalidArgumentException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductDao dao;
	
	@Override
	public Product save(Product product) {
		validate(product);
		product=dao.save(product);
		return product;
		
	}
	
	public void validate(Product product) {
		if(product == null) {
			throw new InvalidArgumentException("customer cant be null ");
			}
	}
	@Override
	public Product findById(String id) {
		Optional<Product> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new ProductNotFoundException("customer not found for id=" + id);
		}
		Product product = optional.get();
		return product;
	}
	
	@Override
	public List<Product> findByName(String name) {
		
		List list = dao.findByName(name);
		return list;	
	}
	
	@Override
	public List<Product> findAllProducts() {
		List list =dao.findAll();
		return list;
	}
	

	
	
}
