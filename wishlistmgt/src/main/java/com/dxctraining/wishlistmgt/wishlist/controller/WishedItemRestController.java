package com.dxctraining.wishlistmgt.wishlist.controller;
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
import org.springframework.web.client.RestTemplate;

import com.dxctraining.wishlistmgt.wishlist.dto.*;
import com.dxctraining.wishlistmgt.wishlist.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishlist.service.IWishlistService;
import com.dxctraining.wishlistmgt.wishlist.util.*;

@RestController
@RequestMapping("/wishedItems")
public class WishedItemRestController {

	@Autowired
	private IWishlistService service;
	
	@Autowired
	private WishlistUtil util;
	
	 @Autowired
	 private RestTemplate rest;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public WishedItemDto create(@RequestBody CreateWishedItemRequest requestData) {
		String productId = requestData.getProductId();
		Integer customerId=requestData.getCustomerId();
		WishedItem wishedItem = new WishedItem(customerId,productId);
		wishedItem = service.save(wishedItem);
		ProductDto productDto = ProductDetailsByProductId(productId);
		CustomerDto customerDto=CustomerDetailsByCustomerId(customerId);
		WishedItemDto response = util.wishedListDto(wishedItem, productId, productDto.getProductName(), customerId, customerDto.getCustomerName());
		return response;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<WishedItemDto> findAllWishedItemsById(@PathVariable("id")int custId) {
		List<WishedItem>list = service.findAll();
		List<WishedItemDto>response = new ArrayList<>();
		for(WishedItem wishedItem:list) {
			String productId = wishedItem.getProductId();
        	ProductDto productDto = ProductDetailsByProductId(productId);
        	int customerId = wishedItem.getCustomerId();
        	CustomerDto customerDto = CustomerDetailsByCustomerId(customerId);
			WishedItemDto dto = util.wishedListDto(wishedItem,productId, productDto.getProductName(),customerId,customerDto.getCustomerName());
			response.add(dto);
		}
		return response;
	}
	
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.CREATED)
	public List<WishedItemDto> fetchAll() {
		
		
		List<WishedItemDto> response = new ArrayList<>();
		List<WishedItem> lists = new ArrayList<>();
		for (WishedItem wishedItem : lists) {
			String productId = wishedItem.getProductId();
			Integer customerId=wishedItem.getCustomerId();
			List<WishedItem> list = service.fetchAll(customerId , productId);
			ProductDto productDto = ProductDetailsByProductId(productId);
			CustomerDto customerDto= CustomerDetailsByCustomerId(customerId);
			WishedItemDto dto = util.wishedListDto(wishedItem, productId, productDto.getProductName(), customerId, customerDto.getCustomerName());
			response.add(dto);
		}
		return response;
	}

	
	 public CustomerDto CustomerDetailsByCustomerId(Integer customerId) {
	    	String url = "http://localhost:8585/customers/get/"+customerId;
	    	CustomerDto dto = rest.getForObject(url, CustomerDto.class);
			return dto;
	    }
	    
	    public ProductDto ProductDetailsByProductId(String productId) {
	    	String url = "http://localhost:8586/products/get/"+productId;
	    	ProductDto dto = rest.getForObject(url, ProductDto.class);
			return dto;
	    }
}