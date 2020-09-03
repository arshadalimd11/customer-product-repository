package com.dxctraining.customermgt.customer.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxctraining.customermgt.customer.entities.*;


public interface ICustomerDao extends JpaRepository<Customer,Integer> {
	
	List<Customer> findByName(String name);

}
