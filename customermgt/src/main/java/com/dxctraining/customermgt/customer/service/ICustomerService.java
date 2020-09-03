package com.dxctraining.customermgt.customer.service;
import com.dxctraining.customermgt.customer.entities.*;
import java.util.*;

public interface ICustomerService {
	
	Customer save(Customer customer);
	Customer findById(Integer id);
	List<Customer> findByName(String name);
	List<Customer> findAll();
}
