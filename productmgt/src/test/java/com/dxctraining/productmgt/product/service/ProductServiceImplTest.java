package com.dxctraining.productmgt.product.service;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.dxctraining.productmgt.product.entities.Product;


@DataMongoTest
@Import(ProductServiceImpl.class)
public class ProductServiceImplTest {

	@Autowired
	private IProductService service;
	
	
	@Test
	public void testSave() {
		String name="Arshad";
		Product product=new Product(name);
		product=service.save(product);	
		Product fetched=service.findById(product.getId());
		Assertions.assertEquals(product.getId(),fetched.getId());
		Assertions.assertEquals(product.getName(),fetched.getName());
		
	}
	@Test
	public void testFindById_1() {
		String name="praveen";
		Product product=new Product(name);
		product=service.save(product);
		String id=product.getId();
		Product fetched=service.findById(id);
		Assertions.assertEquals(product.getId(),fetched.getId());
		Assertions.assertEquals(product.getName(),fetched.getName());
		
	}
	
}