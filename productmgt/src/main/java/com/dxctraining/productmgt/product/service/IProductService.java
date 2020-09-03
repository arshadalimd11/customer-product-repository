package com.dxctraining.productmgt.product.service;
import com.dxctraining.productmgt.product.entities.*;
import java.util.*;

public interface IProductService {
	
	Product save(Product product);
	Product findById(String id);
	List<Product> findByName(String name);
	List<Product> findAllProducts();
}
