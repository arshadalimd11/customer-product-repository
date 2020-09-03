package com.dxctraining.productmgt.product.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.productmgt.product.dto.*;
import com.dxctraining.productmgt.product.entities.Product;
import com.dxctraining.productmgt.product.service.IProductService;
import com.dxctraining.productmgt.product.util.ProductUtil;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ProductUtil util;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody CreateProductRequest requestData) {
		Product product=new Product();
		product.setName(requestData.getName());
		product = productService.save(product);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto getCustomer(@PathVariable("id") String id) {
		Product product = productService.findById(id);
		ProductDto response = util.productDto(product);
		return response;
	}

	@GetMapping("/allcustomers")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ProductDto> fetchAll(){
		List<Product>list=productService.findAllProducts();
		List<ProductDto> response=new ArrayList<>();
		for(Product product:list) {
			ProductDto dto=util.productDto(product);
			response.add(dto);
		}
		return response;
	}
}